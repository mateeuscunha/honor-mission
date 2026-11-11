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
    // atributos constantes para evitar numeros soltos
    private static final int VELOCIDADE = 4;
    private static final int ALCANCE_VASSOURADA = 70;
    private static final int ALCANCE_COLETA = 50;
    private static final int TEMPO_INVULNERAVEL = 30;
    private static final int VIDAS_INICIAIS = 3;
    private static final int PONTOS_POR_RATO = 50;
    
    private boolean espacoPressionado; // evita repetir o golpe enquanto segura a tecla
    private boolean ePressionado; // evita repetir acao enquanto segura a tecla
    private static int vidas = VIDAS_INICIAIS; // atributo para vidas
    private static int invulneravel = 0; // acts restantes sem poder levar dano
    private static int pontuacao = 0;
    private Inventario inventario;
    private Colecao colecao;
    private String sufixoImagem; // complemento do nome da imagem (ex.: "_casa")
    
    /**
     * Construtor padrao para Jogador
     */
    public Jogador()
    {
        espacoPressionado = false;
        ePressionado = false;
        inventario = new Inventario();
        colecao = new Colecao();
        sufixoImagem = "";
        setImage("jogador_frente.png");
    }

    /**
     * A cada act: verifica fim de jogo, reduz a invulnerabilidade,
     * e trata movimento, coleta de itens e ataque.
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
            definirImagem("esquerda");
            setLocation(getX() - VELOCIDADE, getY());
        }
    
        if (Greenfoot.isKeyDown("right"))
        {
            definirImagem("direita");
            setLocation(getX() + VELOCIDADE, getY());
        }
    
        if (Greenfoot.isKeyDown("up"))
        {
            definirImagem("costas");
            setLocation(getX(), getY() - VELOCIDADE);
        }
    
        if (Greenfoot.isKeyDown("down"))
        {
            definirImagem("frente");
            setLocation(getX(), getY() + VELOCIDADE);
        }
    }
    
    /**
     * Escolhe a imagem da direção informada, acrescentando o sufixo
     * definido pelo mundo.
     *
     * @param direcao "esquerda", "direita", "costas" ou "frente".
     */
    private void definirImagem(String direcao)
    {
        setImage("jogador_" + direcao + sufixoImagem + ".png");
    }
    
    /**
     * Sobrescreve um metodo de ator para definir a imagem inicial do jogador.
     */
    @Override
    public void addedToWorld(World mundo)
    {
        definirImagem("frente");
    }
    
    /**
     * Define um sufixo para os arquivos de imagem do jogador, permitindo
     * que o mundo escolha a aparência (ex.: "_casa"). Deve ser chamado
     * antes de adicionar o jogador ao mundo.
     *
     * @param sufixoImagem sufixo acrescentado ao nome da imagem; "" para nenhum.
     */
    public void setSufixoImagem(String sufixoImagem)
    {
        this.sufixoImagem = sufixoImagem;
    }
    
    /**
     * Se o jogador tiver a vassoura e apertar espaco, da uma vassourada:
     * todo rato dentro do alcance morre com um unico golpe.
     */
    private void atacar() {
        boolean espacoAgora = Greenfoot.isKeyDown("space");

        // so ataca no momento em que a tecla eh apertada (nao enquanto segura)
        if (espacoAgora && !espacoPressionado && inventario.contem(Vassoura.NOME)) {
            Greenfoot.playSound("vassourada.wav");

            List<Rato> ratos = getObjectsInRange(ALCANCE_VASSOURADA, Rato.class);

            for (Rato rato : ratos) {
                getWorld().removeObject(rato);
                adicionarPontos(PONTOS_POR_RATO);
                Greenfoot.playSound("rato_morrendo.wav");
            }
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
     * Tira uma vida do jogador, se ele ainda tiver vidas e não estiver
     * invulnerável. Após levar dano, fica 30 acts (~0,5s) invulnerável.
     */
    public static void perderVida()
    {
        if (vidas > 0 && invulneravel == 0)
        {
            vidas--;
            invulneravel = TEMPO_INVULNERAVEL; // ~0,5s de proteção com valor 30
            Greenfoot.playSound("dano.wav");
        }
    }

    /**
     *  Metodo para as vidas voltarem ao reiniciar a partida
     */
    public static void reiniciarVidas()
    {
        vidas = VIDAS_INICIAIS;
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
            List<Item> itens = getObjectsInRange(ALCANCE_COLETA, Item.class);

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
