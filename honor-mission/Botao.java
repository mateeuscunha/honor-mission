import greenfoot.*;
/**
 * Classe geral que representa os botoes no jogo.
 * 
 * @author Gabriel Pedrozo && Mateus Cunha
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
    
    /**
     * Confere se o botao foi clicado ou nao a cada act. Se foi, chama o
     * metodo especifico aoClicar() que, a depender da classe, se comporta
     * de maneira distinta.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            aoClicar();
        }
    }
    
    /**
     * Declara o metodo com a tag abstract, cada classe vai ter sua
     * implementacao.
     */
    public abstract void aoClicar();
}
