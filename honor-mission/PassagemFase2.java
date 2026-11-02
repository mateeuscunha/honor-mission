import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PassagemFase2 here.
 * 
 * @author (Mateus Cunha) 
 * @version (11/02/2026)
 */
public class PassagemFase2 extends Passagem
{
    /**
     * Construtor padrao da PassagemFase2
     */
    public PassagemFase2(int largura, int altura, World destino, int destinoX, int destinoY)
    {
        super(largura, altura, destino, destinoX, destinoY);
    }

    /**
     * So pode passar se nao houver mais ratos no mundo.
     */
    @Override
    protected boolean podePassar() {
        return getWorld().getObjects(Rato.class).isEmpty();
    }
    
    @Override
    protected String mensagemBloqueio() {
        return "Elimine todos os ratos para passar!";
    }
}
