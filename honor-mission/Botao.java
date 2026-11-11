import greenfoot.*;
/**
 * Classe geral que representa os botoes no jogo.
 * 
 * @author (Gabriel Pedrozo && Mateus Cunha) 
 */
public abstract class Botao extends Actor
{
    /**
     * Construtor padrao para botao.
     */
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
