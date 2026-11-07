import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa os roedores que habitam o quartel do TG.
 * 
 * @author (Mateus Cunha) 
 * @version (22/10/2026)
 */
public class Rato extends Vilao
{
    private static final int TEMPO_MORDIDA = 60; // acts entre uma mordida e outra (~1s)
    private int recargaMordida = 0;
    
    /**
     * Act - do whatever the Rato wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (recargaMordida > 0) {
            recargaMordida--;
        }

        if (jogadorPerto()) {
            perseguir(2);
        } else {
            vaguear(1);
        }

        morder();
    }
    
    /**
     * Se estiver encostando no jogador, morde (tira uma vida),
     * respeitando o tempo de recarga.
     */
    private void morder() {
        if (recargaMordida == 0 && isTouching(Jogador.class)) {
            Jogador.perderVida();
            recargaMordida = TEMPO_MORDIDA;

            // FUTURO: tocar som de mordida
            // Greenfoot.playSound("mordida.wav");
        }
    }
}
