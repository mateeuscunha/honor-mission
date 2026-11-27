import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Representa o player: soldado que vai cumprir a missao no TG.
 * 
 * @author (Mateus Cunha && Gabriel Pedrozo) 
 * @version (15/11/2026)
 */
public class Jogador extends Actor
{
    // atributos constantes para evitar numeros soltos
    private static final int VELOCIDADE = 4;
    private static final int ALCANCE_COLETA = 50;

    private Tecla teclaAtacar;
    private Tecla teclaColetar;
    private Tecla teclaCartao;
    private Tecla teclaTiro;

    private int direcao; // ajuda a implementar o tiro. 0 direita, 90 baixo, 180 esquerda, 270 cima.

    private Inventario inventario;
    private Colecao colecao;
    private String sufixoImagem; // complemento do nome da imagem (ex.: "_casa")

    /**
     * Construtor padrao para Jogador
     */
    public Jogador()
    {
        teclaAtacar = new Tecla("space");
        teclaColetar = new Tecla("e");
        teclaCartao = new Tecla("c");
        teclaTiro = new Tecla("f");

        inventario = new Inventario();
        colecao = new Colecao();

        sufixoImagem = "";
        direcao = 90; // comeca olhando para baixo (imagem frente)
        setImage("jogador_frente.png");
    }

    /**
     * A cada act: Trata acoes particulares do jogador.
     */
    public void act()
    {
        movimentar();
        coletarItem();
        atacar();
        atirar();
        usarCartao();
    }

    /**
     * Faz o jogador se movimentar pelo mapa
     */
    private void movimentar() {
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            definirImagem("esquerda");
            direcao = 180;
            setLocation(getX() - VELOCIDADE, getY());
        }

        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            definirImagem("direita");
            direcao = 0;
            setLocation(getX() + VELOCIDADE, getY());
        }

        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))
        {
            definirImagem("costas");
            direcao = 270;
            setLocation(getX(), getY() - VELOCIDADE);
        }

        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))
        {
            definirImagem("frente");
            direcao = 90;
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
        if (teclaAtacar.foiApertada()) {
            inventario.usar(Vassoura.NOME, this);
        }
    }

    /**
     * Se o jogador apertar a tecla de tiro,tenta usar a arma do 
     * inventário.
     */
    private void atirar()
    {
        if (teclaTiro.foiApertada())
        {
            inventario.usar(Arma.NOME, this);
        }
    }

    /**
     * @return direção em que o jogador está olhando, em graus.
     */
    public int getDirecao()
    {
        return direcao;
    }

    /**
     * Se o jogador apertar C, tenta usar o cartao do inventario.
     * O cartao so eh consumido se realmente destrancar alguma porta.
     */
    private void usarCartao()
    {
        if (teclaCartao.foiApertada())
        {
            inventario.usar(Cartao.NOME, this);
        }
    }

    //metodos itens 
    /**
     * Adiciona um item utilizável ao inventário.
     */
    public void adicionarAoInventario(ItemUtilizavel item)
    {
        inventario.adicionar(item);
    }

    /**
     * Retorna o inventario do jogador.
     */
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
            Pontuacao.adicionar(item.getPontos());
        }
    }

    /**
     * Retorna a coleção de itens do jogador.
     */
    public Colecao getColecao()
    {
        return colecao;
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
        if (teclaColetar.foiApertada())
        {
            List<Item> itens = getObjectsInRange(ALCANCE_COLETA, Item.class);

            if (!itens.isEmpty())
            {
                Item item = itens.get(0);
                item.coletadoPor(this);

                getWorld().removeObject(item);
                Greenfoot.playSound("pegar_item.wav");
            }
        }
    }

    // metodo de ambiente
    /**
     * Retorna os Viloes que estao proximos.
     */
    public List<Vilao> getViloesNoAlcance(int alcance) {
        return getObjectsInRange(alcance, Vilao.class);
    }
}