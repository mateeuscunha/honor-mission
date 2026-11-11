import greenfoot.*;

/**
 * Item colecionavel que aumenta a pontuacao do jogador.
 *
 * @author Gabriel Pedrozo
 * @version 10/11/2026
 */
public class Moeda extends ItemColecionavel
{
    /**
     * Construtor de moeda que define o nome, descricao, quantidade de pontos
     * e a imagem do objeto.
     */
    public Moeda()
    {
        super("Moeda", "Uma moeda encontrada pelo caminho.", 100);
        setImage("moeda.png");
    }
}