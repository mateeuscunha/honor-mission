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
    private String tipo;

    /**
     * Cria um item.
     *
     * @param nome nome do item.
     * @param descricao breve descrição do item.
     * @param tipo categoria do item ("UTILIZAVEL" ou "COLECIONAVEL").
     */
    public Item(String nome, String descricao, String tipo)
    {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
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

    /**
     * @return a categoria do item ("UTILIZAVEL" ou "COLECIONAVEL").
     */
    public String getTipo()
    {
        return tipo;
    }
}