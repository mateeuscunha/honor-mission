import java.util.ArrayList;

/**
 * Armazena os itens utilizáveis do jogador.
 *
 * @author Gabriel Pedrozo
 * @version 10/11/2026
 */
public class Inventario
{
    private ArrayList<ItemUtilizavel> itens;

    public Inventario()
    {
        itens = new ArrayList<ItemUtilizavel>();
    }

    public void adicionar(ItemUtilizavel item)
    {
        if (item != null)
        {
            itens.add(item);
        }
    }

    public boolean contem(String nome)
    {
        for (ItemUtilizavel item : itens)
        {
            if (item.getNome().equals(nome))
            {
                return true;
            }
        }

        return false;
    }

    public void remover(String nome)
    {
        for (int i = 0; i < itens.size(); i++)
        {
            if (itens.get(i).getNome().equals(nome))
            {
                itens.remove(i);
                return;
            }
        }
    }

    public boolean usar(String nome, Jogador jogador)
    {
        for (int i = 0; i < itens.size(); i++)
        {
            ItemUtilizavel item = itens.get(i);

            if (item.getNome().equals(nome))
            {
                boolean usado = item.usar(jogador);

                if (usado && item.isConsumivel())
                {
                    itens.remove(i);
                }

                return usado;
            }
        }

        return false;
    }
}

