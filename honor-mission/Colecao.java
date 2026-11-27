import java.util.ArrayList;

/**
 * Armazena os itens colecionáveis encontrados pelo jogador.
 * Cada jogador possui uma coleção, que é transferida de um mundo
 * para o outro quando ele passa por uma Passagem.
 * 
 * @author Gabriel Pedrozo && Mateus Cunha
 * @version 10/11/2026
 */
public class Colecao
{
    private ArrayList<ItemColecionavel> itens; // itens colecionáveis já coletados
    
    /**
     * Cria uma coleção vazia.
     */
    public Colecao()
    {
        itens = new ArrayList<ItemColecionavel>();
    }

    /**
     * Adiciona um item à coleção. Itens nulos são ignorados.
     *
     * @param item item colecionável coletado pelo jogador.
     */
    public void adicionar(ItemColecionavel item)
    {
        if (item != null)
        {
            itens.add(item);
        }
    }

    /**
     * Verifica se a coleção possui pelo menos um item com o nome informado.
     *
     * @param nome nome do item procurado (ex.: Moeda.NOME).
     * @return true se existir um item com esse nome, false caso contrário.
     */
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

    /**
     * Informa quantos itens foram coletados até o momento.
     *
     * @return quantidade de itens na coleção.
     */
    public int getQuantidade()
    {
        return itens.size();
    }

    /**
     * Retorna os itens armazenados na coleção.
     */
    public ArrayList<ItemColecionavel> getItens()
    {
        return new ArrayList<ItemColecionavel>(itens);
    }
}

