import greenfoot.*;

/**
 * Item colecionavel que aumenta a pontuacao do jogador.
 *
 * @author Gabriel Pedrozo && Mateus Cunha
 * @version 10/11/2026
 */
public class Moeda extends ItemColecionavel
{
    public static final String NOME = "Moeda";

    public Moeda()
    {
        super(NOME, "Uma moeda encontrada pelo caminho.", 100);
        setImage("moeda.png");
    }

    @Override
    public GreenfootImage getImagemColecao()
    {
        return new GreenfootImage("moeda_colecao.png");
    }
}