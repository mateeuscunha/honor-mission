import greenfoot.*;

/**
 * Classe botao iniciar 
 * 
 * @author (Gabriel Pedrozo && Mateus Cunha) 
 */
public class BotaoIniciar extends Botao
{
    
    /**
     * Construtor para o botao iniciar.
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
