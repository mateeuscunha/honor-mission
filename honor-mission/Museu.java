import greenfoot.*;
import java.util.List;

/**
 * Representa o museu de relíquias do quartel, onde o jogador
 * precisa encontrar uma maneira de desativar os lasers.
 *
 * @author Mateus Cunha && Gabriel Pedrozo
 * @version 15/11/2026
 */
public class Museu extends MundoJogo
{
    private static boolean lasersAtivos = true;
    private boolean estadoAtualizado = false;
    private World mundoAnterior;

    /**
     * Cria o mundo Museu e prepara o cenário.
     */
    public Museu(World quartel)
    {
        super(1000, 750);
        this.mundoAnterior = quartel;

        if (lasersAtivos)
        {
            setBackground("museu_laser.png");
        }
        else
        {
            setBackground("museu.png");
        }

        prepare();
    }

    /**
     * Desativa os lasers do Museu.
     */
    public static void desativarLasers()
    {
        lasersAtivos = false;
    }

    /**
     * Reinicia os lasers para uma nova partida.
     */
    public static void reiniciarLasers()
    {
        lasersAtivos = true;
    }

    /**
     * Verifica se o estado dos lasers mudou.
     * Atualiza o cenário e remove os lasers quando necessário.
     */
    @Override
    public void act()
    {
        super.act(); // precisar rodar o act do MundoJogo
        
        if (!lasersAtivos && !estadoAtualizado)
        {
            setBackground("museu.png");
            List<Lasers> lasers = getObjects(Lasers.class);

            for (Lasers laser : lasers)
            {
                removeObject(laser);
            }

            estadoAtualizado = true;
        }
    }

    /**
     * Prepara o mundo, adicionando o jogador e os lasers.
     */
    private void prepare()
    {
        escreverDica("Pegue a arma e o cartão", 185, getHeight() - 700);
        escreverDica("Procure por colecionáveis", 189, getHeight() - 680);
        escreverDica("O botão para desativar o laser não está aqui", 274, getHeight() - 660);
        
        Jogador jogador = new Jogador();
        addObject(jogador, 883, 523);

        // adiciona os paineis, herda de MundoJogo
        adicionarPaineis();

        // configuracoes da passagem de volta para o quartel
        Passagem saida = new Passagem (25, 78, mundoAnterior, 139, 367);
        addObject(saida, 926, 389);

        // adicionando os itens do museu
        Cartao cartao = new Cartao();
        addObject(cartao, 74, 363);
        
        Arma arma = new Arma();
        addObject(arma,111,175);
        
        addObject(new Moeda(), 717, 522);

        if (lasersAtivos)
        {
            Lasers laser1 = new Lasers(755, 16);
            addObject(laser1,457,245);
            Lasers lasers2 = new Lasers(745, 10);
            addObject(lasers2,460,372);

            Lasers lasers3 = new Lasers(13, 418);
            addObject(lasers3,681,454);

            Lasers lasers4 = new Lasers(13, 418);
            addObject(lasers4,583,453);

            Lasers lasers5 = new Lasers(10, 419);
            addObject(lasers5,477,374);

            Lasers lasers6 = new Lasers(743, 10);
            addObject(lasers6,455,455);
        }

        Obstaculo mesaCentro = new Obstaculo(306, 133);
        addObject(mesaCentro,454,349);

        Obstaculo banco1 = new Obstaculo(80, 28);
        addObject(banco1,159,501);

        Obstaculo banco2 = new Obstaculo(83, 28);
        addObject(banco2,685,526);

        Obstaculo banco3 = new Obstaculo(92, 30);
        addObject(banco3,400,211);

        Obstaculo mesaComCaps = new Obstaculo(126, 64);
        addObject(mesaComCaps,160,274);

        Obstaculo paredeEsq = new Obstaculo(66, 750);
        addObject(paredeEsq,33,375);

        Obstaculo paredeInf = new Obstaculo(1000, 88);
        addObject(paredeInf,497,705);

        Obstaculo paredeDir = new Obstaculo(61, 750);
        addObject(paredeDir,969,365);

        Obstaculo paredeSup = new Obstaculo(1000, 150);
        addObject(paredeSup,460,72);

        Obstaculo expoBaixo = new Obstaculo(680, 67);
        addObject(expoBaixo,436,588);

        Obstaculo mesaComMosq = new Obstaculo(124, 58);
        addObject(mesaComMosq,162,379);

        Obstaculo paredeAoLadoFarda = new Obstaculo(17, 143);
        addObject(paredeAoLadoFarda,566,174);

        Obstaculo paredeEntreEntrada = new Obstaculo(138, 26);
        addObject(paredeEntreEntrada,713,227);

        Obstaculo paredeEntrada = new Obstaculo(23, 288);
        addObject(paredeEntrada,828,358);

        Obstaculo paredeEntradaInf = new Obstaculo(82, 28);
        addObject(paredeEntradaInf,799,487);

        Obstaculo paredeDentroInf = new Obstaculo(17, 165);
        addObject(paredeDentroInf,767,583);

        Obstaculo mesaComCapsCima= new Obstaculo(112, 47);
        addObject(mesaComCapsCima,236,171);

        Obstaculo planta1 = new Obstaculo(23, 42);
        addObject(planta1,110,450);

        Obstaculo obstaculo19 = new Obstaculo(48, 131);
        addObject(obstaculo19,782,329);

        Obstaculo farda = new Obstaculo(155, 28);
        addObject(farda,663,162);
    }
}

