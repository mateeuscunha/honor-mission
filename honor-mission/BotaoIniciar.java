import greenfoot.*;

/**
 * Classe botao iniciar 
 * 
 * @author (Gabriel Pedrozo && Mateus Cunha) 
 */
public class BotaoIniciar extends Botao
{
    
    /**
     * Constructor for objects of class BotaoIniciar
     */
    public BotaoIniciar()
    {
        super("iniciar_missao.png");
    }

    public void aoClicar()
    {
        Greenfoot.setWorld(new Patio());
        MusicaFundo.tocar();
    }
}
