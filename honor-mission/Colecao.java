import java.util.ArrayList;
import java.util.ArrayList;

/**
 * Armazena os itens colecionáveis encontrados pelo jogador.
 *
 * @author Gabriel Pedrozo
 * @version 10/11/2026
 */
public class Colecao
{
    private ArrayList<ItemColecionavel> itens;

    public Colecao()
    {
        itens = new ArrayList<ItemColecionavel>();
    }

    public void adicionar(ItemColecionavel item)
    {
        if (item != null)
        {
            itens.add(item);
        }
    }

    public boolean contem(String nome)
    {
        for (ItemColecionavel item : itens)
        {
            if (item.getNome().equals(nome))
            {
                return true;
            }
        }

        return false;
    }

    public int getQuantidade()
    {
        return itens.size();
    }
}

