import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa os roedores que habitam o quartel do TG.
 * 
 * @author (Mateus Cunha) 
 * @version (22/10/2026)
 */
public class Rato extends Vilao
{
    /**
     * Act - do whatever the Rato wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (jogadorPerto()) {
            perseguir(2);   
        } else {
            vaguear(1);
        }
    }
    
    
}
