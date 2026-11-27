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
public abstract class Vilao extends Actor
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
     * Procura o jogador dentro do alcance de percepção.
     *
     * @return o jogador, ou null se não houver nenhum por perto.
     */
    protected Jogador getJogadorPerto()
    {
        List<Jogador> jogadores = getObjectsInRange(ALCANCE_PERCEPCAO, Jogador.class);
    
        if (jogadores.isEmpty())
        {
            return null;
        }
    
        return jogadores.get(0);
    }
    
    /**
     * Procura o jogador em qualquer lugar do mundo, sem limite de alcance.
     *
     * @return o jogador, ou null se não houver nenhum no mundo.
     */
    protected Jogador getJogadorNoMundo()
    {
        List<Jogador> jogadores = getWorld().getObjects(Jogador.class);

        if (jogadores.isEmpty())
        {
            return null;
        }

        return jogadores.get(0);
    }
    
    /**
     * Atira na direção do jogador, respeitando o tempo de recarga.
     *
     * @param alvo jogador que será alvo do tiro.
     * @param cooldown quantidade de acts até o próximo tiro.
     */
    protected void atirar(Jogador alvo, int cooldown)
    {
        if (!recargaPronta())
        {
            return;
        }

        Tiro tiro = new Tiro(0);
        getWorld().addObject(tiro, getX(), getY());
        tiro.turnTowards(alvo.getX(), alvo.getY());
        Greenfoot.playSound("tiro.wav");

        iniciarRecarga(cooldown);
    }
    
    /**
     * Indica se o jogador está dentro do alcance de percepção.
     *
     * @return true se há um jogador por perto.
     */
    protected boolean jogadorPerto()
    {
        return getJogadorPerto() != null;
    }

    /**
     * Vira o vilão na direção do jogador e o move em sua direção.
     *
     * @param velocidade pixels percorridos por act.
     */
    protected void perseguir(Jogador alvo, int velocidade)
    {
        turnTowards(alvo.getX(), alvo.getY());
        move(velocidade);
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
            Vidas.perder();
            iniciarRecarga(cooldown);
            Greenfoot.playSound(arquivoSomDaMordida);
        }
    }
    
    /**
     * Reação do vilão a uma vassourada. Por padrão o vilão é imune;
     * subclasses vulneráveis sobrescrevem este método.
     */
    public void sofrerVassourada() { }
    
    /**
     * Reação do vilão a um tiro do jogador. O tiro eh sempre fatal.
     */
    public void sofrerTiro() {
        getWorld().removeObject(this);
    }
}