import greenfoot.*;

/**
 * Esse botao exibe os itens colecionaveis que o jogador pegou durante a partida.
 * 
 * @author Mateus Cunha && Gabriel Pedrozo 
 * @version 25/11/2026
 */
public class BotaoColecao extends Botao
{
    private Colecao colecao;

    /**
     * Construtor para o botao colecao.
     */
    
    public BotaoColecao(Colecao colecao)
    {
        super("botao_colecao.png"); 
        this.colecao = colecao;
    }

    @Override
    public void aoClicar() {
        Greenfoot.setWorld(new TelaColecao(colecao, getWorld())); 
    }
}
