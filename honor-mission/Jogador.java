import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Representa o player: soldado que vai cumprir a missao no TG.
 * 
 * @author (Mateus Cunha && Gabriel Pedrozo) 
 * @version (08/11/2026)
 */
public class Jogador extends Actor
{
    private boolean espacoPressionado; // evita repetir o golpe enquanto segura a tecla
    private boolean ePressionado; // evita repetir a cao enquanto segura a tecla
    private static int vidas = 3; // atributo para vidas
    private static int invulneravel = 0; // acts restantes sem poder levar dano
    private static int pontuacao = 0;
    private Inventario inventario;
    private Colecao colecao;

    /**
     * Construtor padrao para Jogador
     */
    public Jogador()
    {
        espacoPressionado = false;
        ePressionado = false;
        inventario = new Inventario();
        colecao = new Colecao();
    }

    /**
     * Act - do whatever the Jogador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (vidas <= 0) {
            MusicaFundo.parar();
            Greenfoot.playSound("game_over.wav");
            Greenfoot.setWorld(new TelaInicial());
            return;
        }

        if (invulneravel > 0) {
            invulneravel--;
        }

        movimentar();
        coletarItem();
        atacar();
    }

    /**
     * Faz o jogador se movimentar pelo mapa
     */
    private void movimentar() {
        if (Greenfoot.isKeyDown("left"))
        {
            setRotation(0);
            move(-4);
        }

        if (Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
            move(4);
        }

        if (Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
            move(4);
        }

        if (Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
            move(4);
        }
    }

    /**
     * Se o jogador tiver a vassoura e apertar espaco, da uma vassourada:
     * todo rato dentro do alcance morre com um unico golpe.
     */
    private void atacar() {
        boolean espacoAgora = Greenfoot.isKeyDown("space");

        // so ataca no momento em que a tecla eh apertada (nao enquanto segura)
        if (espacoAgora && !espacoPressionado && inventario.contem("Vassoura")) {
            Greenfoot.playSound("vassourada.wav");

            List<Rato> ratos = getObjectsInRange(70, Rato.class);

            for (Rato rato : ratos) {
                getWorld().removeObject(rato);
                adicionarPontos(50);
                Greenfoot.playSound("rato_morrendo.wav");
            }

            // FUTURO: animacao do golpe
            // setImage("jogador_vassourada.png");
        }

        espacoPressionado = espacoAgora;
    }

    //metodos vidas
    /**
     * Metodo de acesso a quantidade de vidas do jogador.
     */
    public static int getVidas()
    {
        return vidas;
    }

    /**
     * Verifica se o jogador ainda tem vidas e diminui uma vida.
     */
    public static void perderVida()
    {
        if (vidas > 0)
        {
            if (vidas > 0 && invulneravel == 0)
            {
                vidas--;
                invulneravel = 30; // ~0,5s de proteção
                Greenfoot.playSound("dano.wav");
            }
        }
    }

    /**
     *  Metodo para as vidas voltarem ao reiniciar a partida
     */
    public static void reiniciarVidas()
    {
        vidas = 3;
        invulneravel = 0;
    }

    //metodos para pontuação
    /**
     * Retorna a pontuação atual do jogador.
     */
    public static int getPontuacao()
    {
        return pontuacao;
    }

    /**
     * Adiciona pontos à pontuação atual.
     *
     * @param pontos quantidade de pontos recebida.
     */
    public static void adicionarPontos(int pontos)
    {
        if (pontos > 0)
        {
            pontuacao += pontos;
        }
    }

    /**
     * Reinicia a pontuação ao iniciar uma nova partida.
     */
    public static void reiniciarPontuacao()
    {
        pontuacao = 0;
    }

    //metodos itens 
    /**
     * Adiciona um item utilizável ao inventário.
     */
    public void adicionarAoInventario(ItemUtilizavel item)
    {
        inventario.adicionar(item);
    }

    public Inventario getInventario()
    {
        return inventario;
    }

    /**
     * Adiciona um item colecionável à coleção.
     */
    public void adicionarNaColecao(ItemColecionavel item)
    {
        if (item != null)
        {
            colecao.adicionar(item);
            adicionarPontos(item.getPontos());
        }
    }

    /**
     * Transfere o inventario e a colecao para o jogador do proximo mundo.
     */
    public void transferirItensPara(Jogador destino)
    {
        destino.inventario = this.inventario;
        destino.colecao = this.colecao;
    }

    /**
     * Verifica se o jogador pode coletar um item próximo.
     */
    private void coletarItem()
    {
        boolean eAgora = Greenfoot.isKeyDown("e");

        if (eAgora && !ePressionado)
        {
            List<Item> itens = getObjectsInRange(50, Item.class);

            if (!itens.isEmpty())
            {
                Item item = itens.get(0);

                if (item.getTipo().equals("UTILIZAVEL"))
                {
                    adicionarAoInventario((ItemUtilizavel) item);
                }
                else if (item.getTipo().equals("COLECIONAVEL"))
                {
                    adicionarNaColecao((ItemColecionavel) item);
                }

                getWorld().removeObject(item);
                Greenfoot.playSound("pegar_item.wav");
            }
        }

        ePressionado = eAgora;
    }

}
