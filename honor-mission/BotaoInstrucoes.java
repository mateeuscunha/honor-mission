import greenfoot.*;
/**
 * Classe que representa o botao que leva para a tela de instrucoes.
 * 
 * @author Gabriel Pedrozo && Mateus Cunha
 * @version 11/10/2026
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
    
    /**
     * Ao clicar, direciona para a tela de instrucoes.
     */
    @Override
    public void aoClicar()
    {
        Greenfoot.setWorld(new TelaInstrucoes());
    }
}
