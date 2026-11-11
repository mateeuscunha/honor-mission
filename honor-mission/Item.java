import greenfoot.*;

/**
 * Classe base para todos os itens do jogo.
 *
 * @author Gabriel Pedrozo && Mateus Cunha
 * @version 10/11/2026
 */
public class Item extends Actor
{
    private String nome;
    private String descricao;

    /**
     * Cria um item.
     *
     * @param nome nome do item.
     * @param descricao breve descrição do item.
     */
    public Item(String nome, String descricao)
    {
        this.nome = nome;
        this.descricao = descricao;
    }

    /**
     * @return o nome do item.
     */
    public String getNome()
    {
        return nome;
    }

    /**
     * @return a descrição do item.
     */
    public String getDescricao()
    {
        return descricao;
    }
}