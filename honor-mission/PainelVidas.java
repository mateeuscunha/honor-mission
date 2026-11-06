import greenfoot.*;
/**
 * exibir as vidas do jogador.
 *
 * @author Gabriel Pedrozo
 * @version 04/11
 */
public class PainelVidas extends Painel
{
    private GreenfootImage coracao;

    public PainelVidas(int x, int y)
    {
        super(x, y);
        coracao = new GreenfootImage("vida.png");
        atualizar();
    }

    public void act()
    {
        atualizar();
    }

    /**
     * verifica a quantidade atual de vidas do jogador, 
     * cria uma imagem transparente e desenha um coração para cada vida disponível,
     * atualizando a imagem do painel na tela.
     */
    public void atualizar()
    {
        int quantidade = Jogador.getVidas();

        GreenfootImage imagem = new GreenfootImage(120, 40);
        imagem.setColor(new Color(0, 0, 0, 0));
        imagem.fill();

        for (int i = 0; i < quantidade; i++)
        {
            imagem.drawImage(coracao, i * 35, 0);
        }

        setImage(imagem);
    }
}

