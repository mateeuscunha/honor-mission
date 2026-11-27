import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa o local onde estao armazenados os materiais belicos.
 * 
 * @author Mateus Cunha
 * @version 18/11/2026
 */
public class ReservaArmamento extends MundoJogo
{
    private Jogador jogador;
    
    /**
     * Construtor para a Reserva de Armamento.
     * 
     */
    public ReservaArmamento()
    {
        super(1000, 750);
        prepare();
    }
    
    /**
     * A cada act, verifica se todos os patifes foram derrotados.
     */
    @Override
    public void act()
    {
        super.act(); // roda o act do MundoJogo (vidas / game over)
    
        if (!Vidas.acabaram() && getObjects(Patife.class).isEmpty())
        {
            Partida.vencer(jogador.getColecao());
        }
    }
    
    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare()
    {
        jogador = new Jogador();
        addObject(jogador, 501, 606);

        // adiciona os paineis, herda de MundoJogo
        adicionarPaineis();

        // adiciona os patifes
        addObject(new Patife(0), 300, 200);
        addObject(new Patife(30), 700, 200);
        addObject(new Patife(60), 500, 400);

        // obstaculos
        Obstaculo parteBaixo = new Obstaculo(1006, 120);
        addObject(parteBaixo,500,696);

        Obstaculo esquerda = new Obstaculo(40, 635);
        addObject(esquerda,20,318);

        Obstaculo direita = new Obstaculo(40, 635);
        addObject(direita,986,318);

        Obstaculo cima = new Obstaculo(925, 40);
        addObject(cima,502,22);

        Obstaculo mesaArma = new Obstaculo(155, 80);
        addObject(mesaArma,883,595);

        Obstaculo cabides = new Obstaculo(730, 180);
        addObject(cabides,610,87);

        Obstaculo armarioMunicao = new Obstaculo(210, 180);
        addObject(armarioMunicao,141,89);

        Obstaculo caixasDireita = new Obstaculo(170, 220);
        addObject(caixasDireita,883,265);

        Obstaculo caixasDireitaBaixo = new Obstaculo(110, 185);
        addObject(caixasDireitaBaixo,909,460);

        Obstaculo armasEsquerda = new Obstaculo(75, 475);
        addObject(armasEsquerda,66,400);

        Obstaculo mesaEsquerda = new Obstaculo(210, 104);
        addObject(mesaEsquerda,161,616);

        Obstaculo objetosEsquerdaFrente = new Obstaculo(41, 215);
        addObject(objetosEsquerdaFrente,111,324);

        Obstaculo caixaPequena = new Obstaculo(50, 70);
        addObject(caixaPequena,784,606);
        
        Obstaculo duasCaixasPequenas = new Obstaculo(90, 30);
        addObject(duasCaixasPequenas,305,624);
    }
}
