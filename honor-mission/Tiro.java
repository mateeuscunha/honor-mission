import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe que representa o disparo da arma de fogo.
 * 
 * @author (Mateus Cunha) 
 * @version (06/11/2026)
 */
public class Tiro extends Actor
{
    private static final int VELOCIDADE = 6;

    // posicao em double para o angulo nao ser distorcido pelo arredondamento
    private double posX;
    private double posY;
    private double angulo; // em radianos

    /**
     * @param anguloGraus direcao do tiro (0 = direita, 90 = baixo)
     */
    public Tiro(int anguloGraus) {
        GreenfootImage imagem = new GreenfootImage("tiro1.png");
        setImage(imagem);

        angulo = Math.toRadians(anguloGraus);
        setRotation(anguloGraus);
    }

    /**
     * Act - do whatever the Tiroo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public void act()
    {
        move(VELOCIDADE);

        if (isAtEdge() || isTouching(Obstaculo.class)) {
            getWorld().removeObject(this);
            return;
        }

        if (isTouching(Jogador.class)) {
            Jogador.perderVida();
            getWorld().removeObject(this);
        }

    }
}
