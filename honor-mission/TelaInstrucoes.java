
import greenfoot.*;

/**
 * Tela que apresenta os controles e objetivos da missao.
 *
 * @author Gabriel Pedrozo
 * @version 10/11/2026
 */
public class TelaInstrucoes extends World
{
    public TelaInstrucoes()
    {
        super(1000, 740, 1);

        // Carrega a imagem de fundo.
        GreenfootImage fundo = new GreenfootImage("instrucoes.png");
        fundo.scale(1000, 750);
        setBackground(fundo);
        // Define as cores dos textos.
        Color branco = Color.WHITE;
        Color dourado = new Color(218, 190, 120);

        // Coluna da esquerda: controles.
        escreverTexto("CONTROLES", 27, dourado, 280, 285);
        escreverTexto("SETAS - Movimentar", 20, branco, 280, 340);
        escreverTexto("E - Coletar itens", 20, branco, 280, 385);
        escreverTexto("ESPACO - Atacar", 20, branco, 280, 430);

        // Coluna da direita: objetivos.
        escreverTexto("OBJETIVOS", 27, dourado, 720, 285);
        escreverTexto("Derrote os ratos", 20, branco, 720, 340);
        escreverTexto("Colete itens pelo mapa", 20, branco, 720, 385);
        escreverTexto("Acumule pontos", 20, branco, 720, 430);

        // Aviso ao jogador.
        escreverTexto("ATENCAO, SOLDADO!", 23, dourado, 500, 510);
        escreverTexto("Voce comeca com 3 vidas. Cuidado com os inimigos!", 
            18, branco, 500, 550);

        // Adiciona o botao de voltar.
        addObject(new BotaoVoltar(), 500, 680);
    }

    /**
     * Desenha um texto centralizado na posicao indicada.
     */
    private void escreverTexto(String texto, int tamanho, Color cor,
    int x, int y)
    {
        GreenfootImage imagem = new GreenfootImage(
                texto, tamanho, cor, new Color(0, 0, 0, 0)
            );

        getBackground().drawImage(
            imagem, x - imagem.getWidth() / 2, y
        );
    }
}

