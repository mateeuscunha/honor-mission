import greenfoot.*;

/**
 * Vigia que patrulha uma rota horizontal e atira no jogador
 * quando ele chega perto.
 *
 * @author Mateus Cunha
 * @version 22/10/2026
 */
public class Vigia extends Vilao
{
    private static final int TEMPO_RECARGA = 45; // acts entre tiros
    private static final int VELOCIDADE_PATRULHA = 3;

    private int limiteEsquerdo;
    private int limiteDireito;
    private boolean patrulhandoOeste;

    /**
     * Cria um vigia que patrulha entre dois limites horizontais.
     *
     * @param limiteEsquerdo coordenada X mais à esquerda da patrulha.
     * @param limiteDireito coordenada X mais à direita da patrulha.
     */
    public Vigia(int limiteEsquerdo, int limiteDireito)
    {
        this.limiteEsquerdo = limiteEsquerdo;
        this.limiteDireito = limiteDireito;
        patrulhandoOeste = false;
    }

    /**
     * Atira se o jogador estiver perto, senão continua patrulhando.
     */
    @Override
    public void act()
    {
        atualizarRecarga();

        if (jogadorPerto())
        {
            atirar();
        }
        else
        {
            patrulhar();
        }
    }

    /**
     * Anda pela rota de patrulha, invertendo o sentido ao chegar nos limites.
     */
    private void patrulhar()
    {
        if (getX() <= limiteEsquerdo)
        {
            patrulhandoOeste = false;
        }
        else if (getX() >= limiteDireito)
        {
            patrulhandoOeste = true;
        }

        if (patrulhandoOeste)
        {
            move(-VELOCIDADE_PATRULHA);
        }
        else
        {
            move(VELOCIDADE_PATRULHA);
        }
    }

    /**
     * Atira na direção do jogador, respeitando o tempo de recarga.
     */
    private void atirar()
    {
        if (!recargaPronta())
        {
            return;
        }

        Jogador jogador = getObjectsInRange(ALCANCE_PERCEPCAO, Jogador.class).get(0);

        Tiro tiro = new Tiro(0);
        getWorld().addObject(tiro, getX(), getY());
        tiro.turnTowards(jogador.getX(), jogador.getY());
        Greenfoot.playSound("tiro.wav");

        iniciarRecarga(TEMPO_RECARGA);
    }
}