import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Representa o player: soldado que vai cumprir a missao no TG.
 * 
 * @author (Mateus Cunha) 
 * @version (22/10/2026)
 */
public class Jogador extends Actor
{
    private boolean temVassoura;
    private boolean espacoPressionado; //evita repetir o golpe enquanto segura a tecla
    
    /**
     * Construtor padrao para Jogador
     */
    public Jogador()
    {
        temVassoura = false;
        espacoPressionado = false;
    }

    /**
     * Act - do whatever the Jogador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movimentar();
        pegarVassoura();
        atacar();
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
    
    /**
 * Se o jogador tiver a vassoura e apertar espaco, da uma vassourada:
 * todo rato dentro do alcance morre com um unico golpe.
 */
private void atacar() {
    boolean espacoAgora = Greenfoot.isKeyDown("space");

    // so ataca no momento em que a tecla eh apertada (nao enquanto segura)
    if (espacoAgora && !espacoPressionado && temVassoura) {
        List<Rato> ratos = getObjectsInRange(70, Rato.class);

        for (Rato rato : ratos) {
            getWorld().removeObject(rato);
        }

        // FUTURO: tocar som de vassourada
        // Greenfoot.playSound("vassourada.wav");

        // FUTURO: animacao do golpe
        // setImage("jogador_vassourada.png");
    }

    espacoPressionado = espacoAgora;
}
}

