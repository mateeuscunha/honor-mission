/**
 * Classe base para itens que podem ser utilizados pelo jogador.
 *
 * @author Gabriel Pedrozo
 * @version 10/11/2026
 */
public class ItemUtilizavel extends Item
{
    private boolean consumivel;

    // Construtor para itens permanentes
    public ItemUtilizavel(String nome, String descricao)
    {
        super(nome, descricao, "UTILIZAVEL");
        this.consumivel = false;
    }

    // Construtor para itens consumíveis
    public ItemUtilizavel(String nome, String descricao, boolean consumivel)
    {
        super(nome, descricao, "UTILIZAVEL");
        this.consumivel = consumivel;
    }

    public boolean isConsumivel()
    {
        return consumivel;
    }

    public boolean usar(Jogador jogador)
    {
        return false;
    }
}