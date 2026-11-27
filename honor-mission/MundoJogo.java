import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe base dos mundos jogáveis (Patio, CasaVigia, Quartel e Museu).
 * Concentra o que é comum a todos: atualização da partida e exibição
 * dos painéis de vidas e pontuação.
 *
 * @author Mateus Cunha
 * @version 18/11/2026
 */
public abstract class MundoJogo extends World
{
    /**
     * Cria um mundo jogável com o tamanho informado.
     */
    public MundoJogo(int largura, int altura)
    {
        super(largura, altura, 1);
    }    
    
    /**
     * A cada act, atualiza o andamento da partida.
     * Subclasses que sobrescreverem este método devem chamar super.act().
     */
    @Override
    public void act()
    {
        Partida.atualizar();
    }
    
    /**
     * Adiciona os painéis de vidas e pontuação na parte inferior do mundo.
     */
    protected void adicionarPaineis()
    {
        PainelVidas painelVidas = new PainelVidas(getWidth() - 80, getHeight() - 25);
        painelVidas.adicionarAoMundo(this);
        
        PainelPontuacao painelPontuacao = new PainelPontuacao(100, getHeight() - 25);
        painelPontuacao.adicionarAoMundo(this);
    }
    
    /**
     * Escreve uma dica que orienta o jogador.
     */
    protected void escreverDica(String dica, int x, int y) {
        showText(dica, x, y);
    }
}