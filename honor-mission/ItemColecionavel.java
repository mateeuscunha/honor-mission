/**
 * Classe base para itens que ficam na coleção do jogador.
 *
 * @author Gabriel Pedrozo
 * @version 10/11/2026
 */
public class ItemColecionavel extends Item
{
    private int pontos;

    public ItemColecionavel(String nome, String descricao, int pontos)
    {
        super(nome, descricao, "COLECIONAVEL");
        this.pontos = pontos;
    }

    public int getPontos()
    {
        return pontos;
    }
}