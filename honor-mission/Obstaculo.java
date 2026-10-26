import greenfoot.*;
/**
 * Classe criada para os os elementos no mapa não serem atravessados pelo jogador;
 * 
 * @author (Gabriel Pedrozo) 
 * @version (24/10)
 */
public class Obstaculo extends Actor
{
    public Obstaculo(int largura, int altura)
    {
        GreenfootImage imagem = new GreenfootImage(largura, altura);
        //imagem.setTransparency(0);
        //imagem.setColor(Color.RED);
        //imagem.fill();
        setImage(imagem);
    }
}
