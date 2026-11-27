import greenfoot.*;
/**
 * Tela exibida quando o jogador vence a missão.
 *
 * @author Gabriel Pedrozo
 * @version 19/11/2026
 */
public class TelaVitoria extends TelaResultado
{
    private Colecao colecao;
    
    /**
     * Cria a tela de vitória e adiciona seus botões.
     */
    public TelaVitoria(Colecao colecao)
    {
        super("tela_vitoria.png", 340, 400, 600, 400);
        this.colecao = colecao;
        prepare();
    }

    /**
     * Adiciona os botões de reiniciar e voltar ao menu.
     */
    private void prepare()
    {
        BotaoReiniciar botaoReiniciar = new BotaoReiniciar("reiniciar_vitoria.png");
        addObject(botaoReiniciar, 274, 629);

        BotaoVoltar botaoVoltar = new BotaoVoltar("sair_vitoria.png");
        addObject(botaoVoltar, 721, 628);
        
        BotaoColecao botaoColecao = new BotaoColecao(this.colecao);
        addObject(botaoColecao,495,627);
    }
}
