import greenfoot.*;
/**
 * Botao para retornar a tela inicial.
 *
 * @author Gabriel Pedrozo
 * @version 10/11/2026
 */
public class BotaoVoltar extends Actor
{
    public BotaoVoltar()
    {
        GreenfootImage imagem = new GreenfootImage("sair.png");

        setImage(imagem);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new TelaInicial());
        }
    }
}

