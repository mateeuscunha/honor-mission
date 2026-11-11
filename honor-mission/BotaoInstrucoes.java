import greenfoot.*;
/**
 * Write a description of class BotaoIniciar here.
 * 
 * @author (Gabriel Pedrozo && Mateus Cunha) 
 * @version (11/10/2026)
 */
public class BotaoInstrucoes extends Botao
{
    /**
     * Construtor para botao de instrucoes.
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
