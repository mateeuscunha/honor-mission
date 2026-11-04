import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Quartel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Quartel extends World
{

    /**
     * Constructor for objects of class Quartel.
     * 
     */
    public Quartel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 750, 1);
        addObject(new Jogador(), 100, 375);

        //Responsavel pelas vidas e sua exibição
        PainelVidas painelVidas = new PainelVidas(80, 30);
        painelVidas.adicionarAoMundo(this);
    }
}
