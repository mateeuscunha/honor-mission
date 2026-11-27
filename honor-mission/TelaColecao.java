import greenfoot.*;
import java.util.HashSet;

/**
 * Tela responsável por exibir os itens coletados durante a partida.
 *
 * @author Gabriel Pedrozo
 * @version 26/11/2026
 */
public class TelaColecao extends World
{
    private Colecao colecao;

    public TelaColecao(Colecao colecao, World telaAnterior)
    {
        super(1000, 750, 1);
        this.colecao = colecao;

        setBackground("tela_colecao.png");
        mostrarItens();

        prepare();
    }

    /**
     * Exibe os itens coletados durante a partida.
     */
    private void mostrarItens()
    {
        int x = 150;
        int y = 250;

        HashSet<String> exibidos = new HashSet<String>();

        for (ItemColecionavel item : colecao.getItens())
        {
            String nome = item.getNome();

            if (!exibidos.contains(nome))
            {
                int quantidade = 0;

                for (ItemColecionavel outro : colecao.getItens())
                {
                    if (outro.getNome().equals(nome))
                    {
                        quantidade++;
                    }
                }

                GreenfootImage imagem = item.getImagemColecao();

                getBackground().drawImage(imagem, x - 75, y);

                showText(nome + " x" + quantidade, x, y + 150);

                exibidos.add(nome);
                x += 200;
            }
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        BotaoVoltarColecao botaoVoltarColecao = new BotaoVoltarColecao(new TelaVitoria(new Colecao()));
        addObject(botaoVoltarColecao,492,651);
    }
}