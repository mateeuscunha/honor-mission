import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa o player: soldado que vai cumprir a missao no TG.
 * 
 * @author (Mateus Cunha) 
 * @version (22/10/2026)
 */
public class Jogador extends Actor
{

    /**
     * Act - do whatever the Jogador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movimentar();
    }
    
    /**
     * Faz o jogador se movimentar pelo mapa
     */
    private void movimentar() {
        if (Greenfoot.isKeyDown("left"))
        {
            setRotation(0);
            move(-4);
        }

        if (Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
            move(4);
        }

        if (Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
            move(4);
        }

        if (Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
            move(4);
        }
    }
}

