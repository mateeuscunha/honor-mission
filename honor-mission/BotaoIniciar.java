import greenfoot.*;

/**
 * Classe do botao iniciar.
 * 
 * @author Gabriel Pedrozo && Mateus Cunha
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
    
    /**
     * Sobrescreve o metodo da superclasse. Ao clicar inicia o jogo.
     */
    @Override
    public void aoClicar()
    {
        Greenfoot.setWorld(new Patio());
        MusicaFundo.tocar();
    }
}
