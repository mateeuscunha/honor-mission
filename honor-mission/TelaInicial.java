import greenfoot.*;
/**
 * Write a description of class TelaInicial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaInicial  extends World
{

    /**
     * Constructor for objects of class TelaInicial
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
