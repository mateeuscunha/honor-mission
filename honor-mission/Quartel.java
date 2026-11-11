import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Quartel here.
 * 
 * @author () 
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
        // Create a new world with 1000x750 cells with a cell size of 1x1 pixels.
        super(1000, 750, 1);
        addObject(new Jogador(), 100, 375);

        //Responsavel pelas vidas e sua exibição
        PainelVidas painelVidas = new PainelVidas(80, getHeight() -20 );
        painelVidas.adicionarAoMundo(this);
        
        //responsavel pelos pontos e sua exibição
        PainelPontuacao painelPontuacao = new PainelPontuacao(150, 30);
        painelPontuacao.adicionarAoMundo(this);
    }
}
