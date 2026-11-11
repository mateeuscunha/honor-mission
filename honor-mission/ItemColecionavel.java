/**
 * Item que vai para a coleção do jogador e vale pontos.
 *
 * @author Gabriel Pedrozo && Mateus Cunha
 * @version 10/11/2026
 */
public class ItemColecionavel extends Item
{
    private int pontos;

    /**
     * Cria um item colecionável.
     *
     * @param nome nome do item.
     * @param descricao breve descrição do item.
     * @param pontos pontos ganhos ao coletar o item.
     */
    public ItemColecionavel(String nome, String descricao, int pontos)
    {
        super(nome, descricao, "COLECIONAVEL");
        this.pontos = pontos;
    }

    /**
     * @return os pontos que o item vale.
     */
    public int getPontos()
    {
        return pontos;
    }
}