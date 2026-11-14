import greenfoot.*;
import java.util.List;

/**
 * Classe base de todos os inimigos do jogo. Reúne os comportamentos comuns:
 * perceber o jogador, perseguir, vaguear e controlar o tempo de recarga
 * de ataques.
 *
 * @author Mateus Cunha
 * @version 25/10/2026
 */
public class Vilao extends Actor
{
    /** Distância, em pixels, em que o vilão percebe o jogador. */
    protected static final int ALCANCE_PERCEPCAO = 100;

    private int recarga = 0; // acts restantes até poder atacar de novo

    /**
     * Diminui a recarga em um act. Deve ser chamado no início do act do vilão.
     */
    protected void atualizarRecarga()
    {
        if (recarga > 0)
        {
            recarga--;
        }
    }

    /**
     * Indica se o vilão já pode atacar novamente.
     *
     * @return true se a recarga terminou.
     */
    protected boolean recargaPronta()
    {
        return recarga == 0;
    }

    /**
     * Inicia a recarga após um ataque.
     *
     * @param duracao quantidade de acts até o próximo ataque.
     */
    protected void iniciarRecarga(int duracao)
    {
        recarga = duracao;
    }

    /**
     * Indica se o jogador está dentro do alcance de percepção.
     *
     * @return true se há um jogador por perto.
     */
    protected boolean jogadorPerto()
    {
        return !getObjectsInRange(ALCANCE_PERCEPCAO, Jogador.class).isEmpty();
    }

    /**
     * Vira o vilão na direção do jogador e o move em sua direção.
     *
     * @param velocidade pixels percorridos por act.
     */
    protected void perseguir(int velocidade)
    {
        List<Jogador> jogadores = getWorld().getObjects(Jogador.class);
        if (!jogadores.isEmpty())
        {
            Jogador jogador = jogadores.get(0);
            turnTowards(jogador.getX(), jogador.getY());
            move(velocidade);
        }
    }

    /**
     * Move o vilão de forma aleatória, mudando de direção de vez em quando.
     *
     * @param velocidade pixels percorridos por act.
     */
    protected void vaguear(int velocidade)
    {
        move(velocidade);
        if (Greenfoot.getRandomNumber(100) < 10)
        {
            int angulo = Greenfoot.getRandomNumber(90) - 45;
            turn(angulo);
        }
    }
    
    /**
     * Se estiver encostando no jogador e a recarga terminou, morde
     * (tira uma vida) e inicia a recarga.
     */
    protected void morder(int cooldown, String arquivoSomDaMordida)
    {
        if (recargaPronta() && isTouching(Jogador.class))
        {
            Jogador.perderVida();
            iniciarRecarga(cooldown);
            Greenfoot.playSound(arquivoSomDaMordida);
        }
    }
}