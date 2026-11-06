import greenfoot.*;
/**
 * Write a description of class BotaoIniciar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotaoInstrucoes extends Botao
{
    
    /**
     * Constructor for objects of class BotaoIniciar
     */
    public BotaoInstrucoes()
    {
        super("botao_instrucoes_new.png");
    }

    public void aoClicar()
    {
        Greenfoot.setWorld(new TelaInstrucoes());
    }
}
