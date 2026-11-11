import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe que representa o quartel.
 * 
 * @author Mateus Cunha 
 * @version 11/11/2026
 */
public class Quartel extends World
{
    /**
     * Construtor para o quartel. SERÁ DESENVOLVIDO PARA AS PRÓXIMAS ENTREGAS.
     */
    public Quartel()
    {    
        super(1000, 750, 1);
        addObject(new Jogador(), 100, 375);

        //Responsavel pelas vidas e sua exibição
        PainelVidas painelVidas = new PainelVidas(80, getHeight() -20 );
        painelVidas.adicionarAoMundo(this);
        
        //responsavel pelos pontos e sua exibição
        PainelPontuacao painelPontuacao = new PainelPontuacao(150, 30);
        painelPontuacao.adicionarAoMundo(this);
        
        // mostra que o jogador chegou no fim do jogo para a primeira entrega
        showText("MISSÃO CUMPRIDA!", 500, 50);
    }
}
