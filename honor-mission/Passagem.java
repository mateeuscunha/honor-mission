import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * A passagem eh um objeto que, quando tocado, leva para outro mundo.
 * 
 * @author (Mateus Cunha) 
 * @version (a version number or a date)
 */
public class Passagem extends Actor
{
    private World destino; //mundo de destino da passagem
    private int destinoX; //coordenada X que o jogador vai aparecer no destino
    private int destinoY; //coordenada Y que o jogador vai aparecer no destino
    private boolean avisando = false;
    
    /**
     * Construtor para a classe Passagem. Cria com altura e largura ajustaveis.
     */
    public Passagem(int largura, int altura, World destino, int destinoX, int destinoY)
    {
        this.destino = destino;
        this.destinoX = destinoX;
        this.destinoY = destinoY;
        
        GreenfootImage imagem = new GreenfootImage(largura, altura);
        //imagem.setColor(Color.BLUE);
        //imagem.fill();
        //imagem.setTransparency(0);
        setImage(imagem);
    }
    
    /**
     * Act - do whatever the Palet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(Jogador.class)) {
            if (podePassar()) {
                entrarNoLugar();
            } else {
                getWorld().showText(mensagemBloqueio(), 500, 50);
                avisando = true;
            }
        } else if (avisando) {
            getWorld().showText(null, 500, 50);
            avisando = false;
        }
    }
    
    /**
     * Mensagem exibida quando o jogador encosta mas nao pode passar.
     * Subclasses podem sobrescrever para dar uma mensagem propria.
     */
    protected String mensagemBloqueio() {
        return "Voce nao pode passar ainda!";
    }
    
    /**
     * Mostra o aviso que esta em mensagemBloqueio na tela.
     */
    private void mostrarAviso() {
        getWorld().showText(mensagemBloqueio(), 500, 50);
    }    
    
    /**
     * Indica se o jogador pode usar a passagem. Por padrao sempre pode;
     * passagens com condicao sobrescrevem este metodo.
     */
    protected boolean podePassar() {
        return true;
    }
    
    /**
     * Altera o mundo principal.
     */
    private void entrarNoLugar() {
        List<Jogador> jogadores = destino.getObjects(Jogador.class);
        if (!jogadores.isEmpty()) {
            Jogador novo = jogadores.get(0);
            Jogador atual = (Jogador) getOneIntersectingObject(Jogador.class);
            
            novo.setLocation(destinoX, destinoY);
            novo.setTemVassoura(atual.temVassoura()); // copia o estado
        }
        Greenfoot.playSound("abrindo_porta.wav");
        
        Greenfoot.setWorld(destino);
    }
}
