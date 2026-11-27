import greenfoot.*;

/**
 * Item colecionavel que aumenta a pontuacao do jogador.
 *
 * @author Mateus Cunha && Gabriel Pedrozo
 * @version 26/11/2026
 */
public class Radio extends ItemColecionavel
{
    public static final String NOME = "Radio";

    public Radio()
    {
        super(NOME, "Uma radio de comunicacao encontrado pelo caminho.", 200);
        setImage("radio.png");
    }

    @Override
    public GreenfootImage getImagemColecao()
    {
        return new GreenfootImage("radio_colecao.png");
    }
}