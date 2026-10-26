import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Vilao here.
 * 
 * @author (Mateus Cunha) 
 * @version (25/10/2026)
 */
public class Vilao extends Actor
{
    /**
     * Act - do whatever the Vilao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    /**
     * Indica se o jogador esta por perto.
     */
    public boolean jogadorPerto() {
        return !getObjectsInRange(100, Jogador.class).isEmpty();
    }
    
    /**
     * Faz o vilao se voltar para a direcao do jogador e comecar a persegui-lo
     */
    public void perseguir(int velocidade) {
        World mundo = getWorld();
        List<Jogador> jogadores = mundo.getObjects(Jogador.class);
        if (!jogadores.isEmpty()) {
            Jogador jogador = jogadores.get(0);
            turnTowards(jogador.getX(), jogador.getY());
            move(velocidade);
        }
    }
    
    /**
     * O vilao fica vagueando (andando aleatoriamente) pelo mapa.
     */
    public void vaguear(int velocidade) {
        move(velocidade);
        if (Greenfoot.getRandomNumber(100) < 10) {
            int angulo = Greenfoot.getRandomNumber(90) - 45;
            turn(angulo);
        }
    }
}
