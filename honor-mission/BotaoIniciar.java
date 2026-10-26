import greenfoot.*;
/**
 * Write a description of class BotaoIniciar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotaoIniciar extends Botao
{
    
    /**
     * Constructor for objects of class BotaoIniciar
     */
    public BotaoIniciar()
    {
        super("start.png");
    }

    public void aoClicar()
    {
        Greenfoot.setWorld(new Patio());
    }
}
