import greenfoot.*;

/**
 * Controla a musica de fundo do jogo.
 * O som fica em um campo static para continuar tocando
 * quando o jogador troca de mundo (Patio <-> CasaVigia).
 * 
 * @author (Mateus Cunha) 
 * @version (11/11/2026)
 */
public class MusicaFundo  
{
    private static final int VOLUME = 40;
    private static GreenfootSound musica = new GreenfootSound("avante_camaradasREDUZIDO.mp3");

    /**
     * Toca a musica em loop. Se ja estiver tocando, nao faz nada,
     * entao chamar de novo nao reinicia a musica.
     */
    public static void tocar()
    {
        if (!musica.isPlaying()) {
            musica.setVolume(VOLUME);
            musica.playLoop();
        }
    }

    /**
     * Para a musica.
     */
    public static void parar()
    {
        musica.stop();
    }
}