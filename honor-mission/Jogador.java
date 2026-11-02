import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa o player: soldado que vai cumprir a missao no TG.
 * 
 * @author (Mateus Cunha) 
 * @version (22/10/2026)
 */
public class Jogador extends Actor
{
    private boolean temVassoura;

    /**
     * Construtor padrao para Jogador
     */
    public Jogador()
    {
        temVassoura = false;
    }
    
    /**
     * Act - do whatever the Jogador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movimentar();
        pegarVassoura();
    }
    
    /**
     * Faz o jogador se movimentar pelo mapa
     */
    private void movimentar() {
        if (Greenfoot.isKeyDown("left"))
        {
            setRotation(0);
            move(-4);
        }

        if (Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
            move(4);
        }

        if (Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
            move(4);
        }

        if (Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
            move(4);
        }
    }
    
    /**
     * Se o jogador encostar na vassoura, pega o item e ela some do mapa.
     */
    private void pegarVassoura() {
        Actor vassoura = getOneIntersectingObject(Vassoura.class);
        if (vassoura != null) {
            getWorld().removeObject(vassoura);
            temVassoura = true;
            
            // FUTURO: tocar som de pegar item
            // Greenfoot.playSound("pegar_item.wav");
            
            // FUTURO: trocar imagem do jogador para o boneco com vassoura
            // setImage("jogador_vassoura.png");
        }
    }
    
    /**
     * Indica se o jogador ja pegou a vassoura.
     */
    public boolean temVassoura() {
        return temVassoura;
    }
    
    /**
     * Atualiza o estado do atributo temVassoura do jogador com
     * o valor(true ou false) recebido por parametro.
     */
    public void setTemVassoura(boolean valor) {
    temVassoura = valor;
    if (temVassoura) {
        // setImage("jogador_vassoura.png");
    }
}
}

