import greenfoot.*;

/**
 * Controla a musica de fundo do jogo.
 * 
 * @author (Mateus Cunha) 
 * @version (11/09/2026)
 */
public class Musica 
{
    private int volume;
    private GreenfootSound som;
    
    /**
     * Recebe o nome do arquivo e cria uma musica para ser tocada
     */
    public Musica (String arquivo, int volume) {
        som = new GreenfootSound(arquivo);
        this.volume = volume;
    }

    /**
     * Toca a musica em loop. Se ja estiver tocando, nao faz nada,
     * entao chamar de novo nao reinicia a musica.
     */
    public void tocar()
    {
        if (!som.isPlaying()) {
            som.setVolume(volume);
            som.playLoop();
        }
    }

    /**
     * Para a musica.
     */
    public void parar()
    {
        som.stop();
    }
}