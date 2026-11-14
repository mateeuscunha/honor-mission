import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Essa classe representa o quartel: ambiente principal da segunda fase do jogo.
 * @author Mateus Cunha
 * @version 14/11/2026
 */
public class Quartel extends World
{
    /**
     * Construtor para o quartel.
     */
    public Quartel()
    {    
        super(1000, 750, 1);
        prepare();
    }
     /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare()
    {
        Jogador jogador = new Jogador();
        addObject(jogador, 250, 580);
        
        //Responsavel pelas vidas e sua exibição
        PainelVidas painelVidas = new PainelVidas(getWidth() - 80, getHeight() - 25);
        painelVidas.adicionarAoMundo(this);
        
        //responsavel pelos pontos e sua exibição
        PainelPontuacao painelPontuacao = new PainelPontuacao(100, getHeight() -25);
        painelPontuacao.adicionarAoMundo(this);
        
        // Adicionando os viloes
        addObject(new Cachorro(), 223, 400);
        addObject(new Cachorro(), 336, 274);
        addObject(new Cachorro(), 443, 400);
        addObject(new Cachorro(), 727, 526);
    }
}
