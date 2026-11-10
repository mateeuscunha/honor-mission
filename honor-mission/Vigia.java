import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa um vigia vilao, que patrulha para proteger o saque ao TG.
 * 
 * @author (Mateus Cunha) 
 * @version (22/10/2026)
 */
public class Vigia extends Vilao
{   
    private static final int TEMPO_RECARGA = 45; // acts entre um tiro e outro
    
    private boolean patrulhandoOeste;
    private int recarga = 0;
    
    /**
     * Act - do whatever the Vigia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (recarga > 0) {
            recarga--;
        }
        
        if(jogadorPerto()) {
            atirar();
        } else {
            patrulhar();   
        }
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
    
    /**
     * Atira na direcao do jogador, respeitando o tempo de recarga.
     */
    private void atirar() {
        if (recarga > 0) {
            return;
        }
        
        Jogador jogador = getObjectsInRange(100, Jogador.class).get(0);
        
        Tiro tiro = new Tiro(0);
        getWorld().addObject(tiro, getX(), getY());
        tiro.turnTowards(jogador.getX(), jogador.getY());
        Greenfoot.playSound("tiro.wav");
        
        recarga = TEMPO_RECARGA;
    }
}
