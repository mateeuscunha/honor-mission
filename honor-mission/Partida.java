import greenfoot.*;

/**
 * Controla o andamento da partida: passagem do tempo de invulnerabilidade
 * e verificação de fim de jogo. Os membros são estáticos para que possam
 * ser chamados por qualquer mundo.
 *
 * @author Mateus Cunha && Gabriel Pedrozo
 * @version 19/11/2026
 */
public class Partida
{
    private static Musica musicaFundo = new Musica("avante_camaradas.wav", 50);
    private static Musica musicaVitoria = new Musica("fibra_de_heroi.wav", 80);
    private static Musica musicaDerrota = new Musica("toque_funebre.wav", 80);
    private static long inicio; //long para evitar overflow

    /**
     * Classe utilitária: não deve ser instanciada.
     */
    private Partida() { }

    /**
     * Inicia a partida com pontuacao, vida e lasers do zero.
     */
    public static void iniciar()
    {
        musicaVitoria.parar();
        musicaDerrota.parar();
        Vidas.reiniciar();
        Pontuacao.reiniciar();
        Museu.reiniciarLasers();
        musicaFundo.tocar();
        Greenfoot.setWorld(new Patio());
        inicio = System.currentTimeMillis();
    }

    public static void iniciarTempo()
    {
        inicio = System.currentTimeMillis();
    }

    public static String getTempoFormatado()
    {
        long tempo = (System.currentTimeMillis() - inicio) / 1000;

        return String.format("%02d:%02d", tempo / 60, tempo % 60);
    }

    /**
     * Deve ser chamado uma vez por act pelo mundo ativo.
     * Faz passar o tempo de invulnerabilidade e encerra a partida
     * se o jogador ficou sem vidas.
     */
    public static void atualizar()
    {
        Vidas.passarTempo();

        if (Vidas.acabaram())
        {
            encerrarPorDerrota();
        }
    }

    /**
     * Para a música, toca o som de game over e volta para a tela inicial.
     */
    private static void encerrarPorDerrota()
    {
        musicaFundo.parar();
        //Greenfoot.playSound("game_over.wav");
        musicaDerrota.tocar();
        Greenfoot.setWorld(new TelaDerrota());
    }

    /**
     * Encerra a partida com vitória: para a música de fundo, toca a música
     * de vitória e vai para a tela de vitória.
     */
    public static void vencer(Colecao colecao)
    {
        musicaFundo.parar();
        musicaVitoria.tocar();
        Greenfoot.setWorld(new TelaVitoria(colecao));
    }

    /**
     * Volta para a tela inicial, parando qualquer música que esteja tocando.
     */
    public static void voltarAoMenu()
    {
        musicaVitoria.parar();
        musicaDerrota.parar();
        musicaFundo.parar();
        Greenfoot.setWorld(new TelaInicial());
    }
}