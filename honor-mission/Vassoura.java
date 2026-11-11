import greenfoot.*;

/**
 * Item utilizável que permite ao jogador atacar os ratos.
 *
 * @author Gabriel Pedrozo && Mateus Cunha
 * @version 24/10/2026
 */
public class Vassoura extends ItemUtilizavel
{
    /** Nome usado para identificar a vassoura no inventário. */
    public static final String NOME = "Vassoura"; 
    /* 
     * Esse atributo faz sentido ser publico, ja que ele que a sua funcao eh
     * ser um identificador no inventario. Outras classes precisarao acessa-lo.
     * Alem disso, ele eh uma constante, ninguem vai conseguir altera-lo, logo
     * nao fere o conceito de encapsulamento
     */
    /**
     * Cria a vassoura.
     */
    public Vassoura()
    {
        super(NOME, "Permite atacar os ratos.");
    }
}