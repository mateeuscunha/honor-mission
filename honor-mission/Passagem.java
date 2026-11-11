import greenfoot.*;
import java.util.List;

/**
 * Objeto invisível que, ao ser tocado pelo jogador, leva para outro mundo.
 * Subclasses podem impor condições para a passagem (ver {@link #podePassar()}).
 *
 * @author Mateus Cunha
 * @version 10/11/2026
 */
public class Passagem extends Actor
{
    private static final int AVISO_X = 500; // posição X da mensagem de bloqueio
    private static final int AVISO_Y = 50;  // posição Y da mensagem de bloqueio

    private World destino;   // mundo de destino da passagem
    private int destinoX;    // coordenada X em que o jogador aparece no destino
    private int destinoY;    // coordenada Y em que o jogador aparece no destino
    private boolean avisando = false;

    /**
     * Cria uma passagem com tamanho ajustável.
     *
     * @param largura largura da área da passagem.
     * @param altura altura da área da passagem.
     * @param destino mundo para o qual a passagem leva.
     * @param destinoX coordenada X do jogador no mundo de destino.
     * @param destinoY coordenada Y do jogador no mundo de destino.
     */
    public Passagem(int largura, int altura, World destino, int destinoX, int destinoY)
    {
        this.destino = destino;
        this.destinoX = destinoX;
        this.destinoY = destinoY;
        setImage(new GreenfootImage(largura, altura));
    }

    /**
     * Se o jogador tocar a passagem, entra no destino caso possa;
     * senão exibe o aviso de bloqueio até ele se afastar.
     */
    @Override
    public void act()
    {
        if (isTouching(Jogador.class))
        {
            if (podePassar())
            {
                entrarNoLugar();
            }
            else
            {
                getWorld().showText(mensagemBloqueio(), AVISO_X, AVISO_Y);
                avisando = true;
            }
        }
        else if (avisando)
        {
            getWorld().showText(null, AVISO_X, AVISO_Y);
            avisando = false;
        }
    }

    /**
     * Mensagem exibida quando o jogador encosta mas não pode passar.
     * Subclasses podem sobrescrever para dar uma mensagem própria.
     *
     * @return o texto do aviso.
     */
    protected String mensagemBloqueio()
    {
        return "Voce nao pode passar ainda!";
    }

    /**
     * Indica se o jogador pode usar a passagem. Por padrão sempre pode;
     * passagens com condição sobrescrevem este método.
     *
     * @return true se a passagem está liberada.
     */
    protected boolean podePassar()
    {
        return true;
    }

    /**
     * Leva o jogador ao mundo de destino: posiciona o jogador de lá,
     * transfere inventário e coleção, toca o som da porta e troca de mundo.
     */
    private void entrarNoLugar()
    {
        List<Jogador> jogadores = destino.getObjects(Jogador.class);
        if (!jogadores.isEmpty())
        {
            Jogador novo = jogadores.get(0);
            Jogador atual = (Jogador) getOneIntersectingObject(Jogador.class);

            novo.setLocation(destinoX, destinoY);
            atual.transferirItensPara(novo);
        }
        Greenfoot.playSound("abrindo_porta.wav");

        Greenfoot.setWorld(destino);
    }
}