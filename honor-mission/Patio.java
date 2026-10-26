import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Patio do Tiro de Guerra: onde o jogo inicia.
 * 
 * @author (Mateus Cunha) 
 * @version (22/10/2026)
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
        Obstaculo paredeInferior = new Obstaculo(935, 36);
        addObject(paredeInferior,551,697);
        paredeInferior.setLocation(510,710);
        Obstaculo paredeDireita = new Obstaculo(21, 702);
        addObject(paredeDireita,970,363);
        Obstaculo arvoreMeio = new Obstaculo(50, 39);
        addObject(arvoreMeio,599,467);
        arvoreMeio.setLocation(601,469);
        Obstaculo arvoreLado1 = new Obstaculo(34, 34);
        addObject(arvoreLado1,66,325);
        arvoreLado1.setLocation(68,328);
        Obstaculo arvoreLado2 = new Obstaculo(34, 34);
        addObject(arvoreLado2,67,489);
        arvoreLado2.setLocation(68,492);
        Obstaculo arvoreLado3 = new Obstaculo(34, 34);
        addObject(arvoreLado3,67,655);
        arvoreLado3.setLocation(67,657);
        Obstaculo cantina = new Obstaculo(289, 154);
        addObject(cantina,205,120);
        Obstaculo casaVigiaEsq = new Obstaculo(196, 156);
        addObject(casaVigiaEsq,577,105);
        casaVigiaEsq.setLocation(574,92);
        Obstaculo casaVigiaDir = new Obstaculo(194, 149);
        addObject(casaVigiaDir,841,102);
        casaVigiaDir.setLocation(833,94);
        Obstaculo guarita = new Obstaculo(55, 77);
        addObject(guarita,908,266);
        guarita.setLocation(912,266);
        Obstaculo casinha = new Obstaculo(95, 82);
        addObject(casinha,883,603);
        casinha.setLocation(884,597);
    }
}
