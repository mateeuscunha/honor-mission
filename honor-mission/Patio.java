import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Patio do Tiro de Guerra: onde o jogo inicia.
 * 
 * @author (Mateus Cunha && Gabriel Pedrozo) 
 * @version (08/11/2026)
 */
public class Patio extends World
{
    /**
     * Constructor for objects of class Patio.
     * 
     */
    public Patio()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(1000, 750, 1); 
        prepare();

        //Responsavel pelas vidas e sua exibição
        Jogador.reiniciarVidas();//reinicia as vidas ao recomeçar
        //getHeight posiciona o painel próximo à parte inferior do mundo(independente dos pxs).
        PainelVidas painelVidas = new PainelVidas(getWidth() - 80, getHeight() - 25);
        painelVidas.adicionarAoMundo(this);

        //responsavel pelos pontos e sua exibição
        Jogador.reiniciarPontuacao();
        PainelPontuacao painelPontuacao = new PainelPontuacao(100, getHeight() -25);
        painelPontuacao.adicionarAoMundo(this);
    }

    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare()
    {
        Jogador jogador = new Jogador();
        addObject(jogador,883,523);
        Vigia vigia = new Vigia();
        addObject(vigia,754,265);
        Rato rato = new Rato();
        addObject(rato,354,265);
        Rato rato2 = new Rato();
        addObject(rato2,452,307);
        Rato rato3 = new Rato();
        addObject(rato3,451,254);
        Rato rato4 = new Rato();
        addObject(rato4,375,313);

        // configuracoes da passagem
        CasaVigia casaVigia = new CasaVigia(this);
        Passagem passagem = new Passagem(50, 65, casaVigia, 608, 365);
        addObject(passagem,704,160);

        //adciona colisoes e obstaculso patio
        Obstaculo peredeEsquerda = new Obstaculo(39, 719);
        addObject(peredeEsquerda,18,432);
        peredeEsquerda.setLocation(21,361);

        Obstaculo paredeDireita = new Obstaculo(60, 702);
        addObject(paredeDireita,972,338);

        Obstaculo paredeInferior = new Obstaculo(1000, 64);
        addObject(paredeInferior,521,718);
        paredeInferior.setLocation(501,721);

        Obstaculo fase2 = new Obstaculo(366, 194);
        addObject(fase2,186,98);

        Obstaculo arvoreMeio = new Obstaculo(48, 92);
        addObject(arvoreMeio,601,444);
        Obstaculo arvoreLado1 = new Obstaculo(38, 66);
        addObject(arvoreLado1,68,309);
        Obstaculo arvoreLado2 = new Obstaculo(38, 66);
        addObject(arvoreLado2,67,471);
        arvoreLado2.setLocation(67,472);
        Obstaculo arvoreLado3 = new Obstaculo(38, 66);
        addObject(arvoreLado3,63,649);
        arvoreLado3.setLocation(67,639);
        Obstaculo escadaCima = new Obstaculo(129, 48);
        addObject(escadaCima,412,35);
        escadaCima.setLocation(410,25);

        Obstaculo casaVigiaEsq = new Obstaculo(219, 174);
        addObject(casaVigiaEsq,568, 84);
        Obstaculo casaVigiaDir = new Obstaculo(236, 176);
        addObject(casaVigiaDir,849,86);
        Obstaculo cimaPorta = new Obstaculo(75, 125);
        addObject(cimaPorta,693,58);

        Obstaculo casinha = new Obstaculo(95, 82);
        addObject(casinha,883,603);
        casinha.setLocation(884,597);

        Obstaculo guarita = new Obstaculo(59, 112);
        addObject(guarita,910,259);
        guarita.setLocation(912,250);

        // passagem para a fase 2 (so libera quando nao houver ratos)
        Quartel quartel = new Quartel();
        PassagemFase2 passagemFase2 = new PassagemFase2(35, 10, quartel, 225, 200);
        addObject(passagemFase2, 240, 203);

        
        
    }
}