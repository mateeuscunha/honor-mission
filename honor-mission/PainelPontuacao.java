import greenfoot.*;
/**
 * Exibe a pontuação atual do jogador.
 *
 * @author Gabriel Pedrozo
 * @version 08/11
 */
public class PainelPontuacao extends Painel
{
    public PainelPontuacao(int x, int y)
    {
        super(x, y);
        atualizar();
    }

    public void act()
    {
        atualizar();
    }

    /**
     * Consulta a pontuação do jogador e atualiza sua exibição.
     */
    public void atualizar()
    {
        int pontuacao = Jogador.getPontuacao();

        GreenfootImage imagem = new GreenfootImage(190, 45);

        // Fundo escuro
        imagem.setColor(new Color(25, 25, 35, 210));
        imagem.fillRect(0, 0, 190, 45);

        // Borda verde militar 
        imagem.setColor(new Color(85, 107, 47));
        imagem.drawRect(0, 0, 189, 44);

        // Texto da pontuação
        imagem.setColor(new Color(85, 107, 47));
        imagem.setFont(new Font("Arial", true, false, 22));
        imagem.drawString("Pontos: " + pontuacao, 15, 30);

        setImage(imagem);
    }
}