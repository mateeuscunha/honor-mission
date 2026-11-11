import greenfoot.*;

/**
 * Botão que leva o jogador de volta à tela inicial.
 *
 * @author Gabriel Pedrozo && Mateus Cunha
 * @version 10/11/2026
 */
public class BotaoVoltar extends Botao
{
    /**
     * Cria o botão de voltar com a imagem de saída.
     */
    public BotaoVoltar()
    {
        super("sair.png");
    }

    /**
     * Ao clicar, retorna para a tela inicial do jogo.
     */
    @Override
    public void aoClicar()
    {
        Greenfoot.setWorld(new TelaInicial());
    }
}