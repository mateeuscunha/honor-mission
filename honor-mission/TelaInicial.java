import greenfoot.*;
/**
 * Tela inicial do jogo.
 * 
 * @author Gabriel Pedrozo && Mateus Cunha
 * @version (11/10/2026)
 */
public class TelaInicial  extends World
{
    /**
     * Construtor padrao para a tela inicial.
     */
    public TelaInicial()
    {
        super(1000, 750, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        BotaoIniciar botaoIniciar = new BotaoIniciar();
        addObject(botaoIniciar,753,587);

        BotaoInstrucoes botaoInstrucoes = new BotaoInstrucoes();
        addObject(botaoInstrucoes,362,598);
        
        botaoIniciar.setLocation(147,636);
        botaoInstrucoes.setLocation(324,635);
    }
}
