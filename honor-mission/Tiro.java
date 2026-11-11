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

    /**
     * @param anguloGraus direcao do tiro (0 = direita, 90 = baixo)
     */
    public Tiro(int anguloGraus) {
        GreenfootImage imagem = new GreenfootImage("tiro1.png");
        setImage(imagem);

        setRotation(anguloGraus);
    }

    /**
     * Act - O tiro se move na direcao do angulo inicial calculado de acordo
     * com o jogador. Se acerta o jogador, da dano. Caso encoste na parede
     * (obstaculo ou limites do mapa) o tiro some.
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
