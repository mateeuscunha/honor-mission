import greenfoot.*;
/**
 * Write a description of class BotaoMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Botao extends Actor
{

    public Botao(String arquivoImagem)
    {
        setImage(new GreenfootImage(arquivoImagem)); //Imagem do botao
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            aoClicar();
        }
    }

    public abstract void aoClicar();
}
