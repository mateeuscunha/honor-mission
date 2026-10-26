import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa um vigia vilao, que patrulha para proteger o saque ao TG.
 * 
 * @author (Mateus Cunha) 
 * @version (22/10/2026)
 */
public class Vigia extends Vilao
{   
    boolean patrulhandoOeste;
    
    /**
     * Act - do whatever the Vigia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        patrulhar();
    }
    
    /**
     * Vigia se movimenta pela rota de patrulha
     */
    private void patrulhar() {
        if (getX() <= 564) {
            patrulhandoOeste = false;
        } else if (getX() >= 864) {
            patrulhandoOeste = true;
        }
        if (patrulhandoOeste) {
            move(-3);
        } else {
            move(3);
        }
    }
}
