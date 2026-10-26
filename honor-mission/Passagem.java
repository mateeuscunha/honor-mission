import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * A passagem eh um objeto que, quando tocado, leva para outro mundo.
 * 
 * @author (Mateus Cunha) 
 * @version (a version number or a date)
 */
public class Passagem extends Actor
{
    private World destino; //mundo de destino da passagem
    private int destinoX; //coordenada X que o jogador vai aparecer no destino
    private int destinoY; //coordenada Y que o jogador vai aparecer no destino
    
    /**
     * Construtor para a classe Passagem. Cria com altura e largura ajustaveis.
     */
    public Passagem(int largura, int altura, World destino, int destinoX, int destinoY)
    {
        this.destino = destino;
        this.destinoX = destinoX;
        this.destinoY = destinoY;
        
        GreenfootImage imagem = new GreenfootImage(largura, altura);
        imagem.setColor(Color.BLUE);
        imagem.fill();
        //imagem.setTransparency(0);
        setImage(imagem);
    }
    
    /**
     * Act - do whatever the Palet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(Jogador.class)) {
            entrarNoLugar();
        }
    }
    
    /**
     * Altera o mundo principal.
     */
    private void entrarNoLugar() {
        List<Jogador> jogadores = destino.getObjects(Jogador.class);
        if (!jogadores.isEmpty()) {
            jogadores.get(0).setLocation(destinoX, destinoY);
        }
        
        Greenfoot.setWorld(destino);
    }
}
