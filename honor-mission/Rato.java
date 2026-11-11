import greenfoot.*;

/**
 * Rato que vagueia pelo mapa, persegue o jogador quando ele chega perto
 * e o morde, tirando uma vida.
 *
 * @author Mateus Cunha
 * @version 22/10/2026
 */
public class Rato extends Vilao
{
    private static final int TEMPO_MORDIDA = 60; // acts entre mordidas (~1s)

    /**
     * Persegue o jogador se ele estiver perto, senão vagueia.
     * Em seguida tenta morder.
     */
    @Override
    public void act()
    {
        atualizarRecarga();

        if (jogadorPerto())
        {
            perseguir(2);
        }
        else
        {
            vaguear(1);
        }

        morder();
    }

    /**
     * Se estiver encostando no jogador e a recarga terminou, morde
     * (tira uma vida) e inicia a recarga.
     */
    private void morder()
    {
        if (recargaPronta() && isTouching(Jogador.class))
        {
            Jogador.perderVida();
            iniciarRecarga(TEMPO_MORDIDA);
            Greenfoot.playSound("mordida.wav");
        }
    }
}