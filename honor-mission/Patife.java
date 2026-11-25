import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Assaltante do Tiro de Guerra, inimigo final.
 * Fica parado e atira no jogador onde quer que ele esteja no mundo.
 * 
 * @author Mateus Cunha
 * @version 18/11/2026
 */
public class Patife extends Vilao
{
    private static final int TEMPO_RECARGA = 90; // acts entre tiros (~1,5s)
    
    /**
     * Cria um patife com um atraso inicial antes do primeiro tiro.
     * Dar atrasos diferentes evita que todos atirem no mesmo instante.
     *
     * @param atrasoInicial acts de espera antes do primeiro tiro.
     */
    public Patife (int atrasoInicial) {
        setImage("saqueador50x58.png");
        iniciarRecarga(atrasoInicial);
    }
    
    /**
     * Construtor padrão: atira assim que o jogador aparece.
     */
    public Patife()
    {
        this(0);
    }
    
    /**
     * Fica parado e atira no jogador, esteja ele onde estiver.
     */
    public void act() {
        atualizarRecarga();
        
        Jogador alvo = getJogadorNoMundo();
        
        if (alvo != null) {
            atirar(alvo, TEMPO_RECARGA);
        }
    }
    
    /**
     * O patife morre com um golpe.
     */
    @Override
    public void sofrerVassourada()
    {
        Greenfoot.playSound("patife.wav");
        getWorld().removeObject(this);
    }
    
    /**
     * Sobrescreve o metodo do vilao, pois o patife emite som quando baleado.
     */
    @Override
    public void sofrerTiro() {
        super.sofrerTiro();
        Greenfoot.playSound("patife.wav");
    }
}
