import greenfoot.*;
/**
 * Painel
 * 
 * @author (Gabriel Pedrozo) 
 * @version (04/11)
 */
public abstract class Painel extends Actor
{
    private int posicaoX;
    private int posicaoY;

    public Painel(int x, int y)
    {
        posicaoX = x;
        posicaoY = y;
    }

    /**
     * Adiciona o painel ao mundo informado, utilizando as coordenadas
     * de posição X e Y definidas em seu construtor.
     * 
     * @param mundo mundo no qual o painel será adicionado.
     */
    public void adicionarAoMundo(World mundo)
    {
        mundo.addObject(this, posicaoX, posicaoY);
    }
}    
