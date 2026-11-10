import greenfoot.*;

/**
 * Classe base para todos os itens do jogo.
 *
 * @author Gabriel Pedrozo
 * @version 10/11/2026
 */
public class Item extends Actor
{
    private String nome;
    private String descricao;
    private String tipo;

    public Item(String nome, String descricao, String tipo)
    {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public String getNome()
    {
        return nome;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public String getTipo()
    {
        return tipo;
    }
}