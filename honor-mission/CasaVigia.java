import greenfoot.*;
/**
 * essa classe representa o cenário da casa do vigia
 * 
 * @author (Gabriel Pedrozo && Mateus Cunha) 
 * @version (24/10/2026)
 */
public class CasaVigia  extends World
{
    private World mundoAnterior;
    
    /**
     * Construtor do mundo Casa do Vigia.
     */
    public CasaVigia(World patio)
    {
        super(1200, 470, 1);
        this.mundoAnterior = patio;
        prepare();
    }

    /**
     * Volta para o mundo anterior.
     */
    public void voltarAoMundoAnterior() {
        Greenfoot.setWorld(mundoAnterior);
    }
    
    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */

    private void prepare()
    {
        Jogador jogador = new Jogador();
        jogador.getImage().scale(30,52);
        addObject(jogador, 612, 375);

        Vassoura vassoura = new Vassoura();
        vassoura.getImage().scale(35, 75);
        addObject(vassoura, 257, 130);

        // configuracoes da passagem de volta para o patio
        Passagem saida = new Passagem (50, 20, mundoAnterior, 776, 187);
        addObject(saida, 612, 429);

        //conficuracoes colisoes do mundo
        Obstaculo cama = new Obstaculo(103, 143);
        addObject(cama,527,136);
        Obstaculo mesinhaCama = new Obstaculo(65, 70);
        addObject(mesinhaCama,624,99);
        mesinhaCama.setLocation(624,106);
        Obstaculo tv = new Obstaculo(89, 83);
        addObject(tv,806,94);
        tv.setLocation(809,99);
        Obstaculo mesa = new Obstaculo(97, 95);
        addObject(mesa,660,282);
        Obstaculo armario = new Obstaculo(310, 119);
        addObject(armario,135,108);
        armario.setLocation(171,88);
        Obstaculo prateleiras = new Obstaculo(47, 239);
        addObject(prateleiras,45,296);
        prateleiras.setLocation(42,305);
        Obstaculo caixa = new Obstaculo(38, 76);
        addObject(caixa,79,368);
        caixa.setLocation(82,368);
        Obstaculo paredeInferiorEsquerda = new Obstaculo(557, 21);
        addObject(paredeInferiorEsquerda,410,442);
        paredeInferiorEsquerda.setLocation(283,435);
        Obstaculo paredeInferiorDireita = new Obstaculo(537, 21);
        addObject(paredeInferiorDireita,936,433);
        paredeInferiorDireita.setLocation(920,432);
        Obstaculo lixo = new Obstaculo(28, 75);
        addObject(lixo,1161,367);
        lixo.setLocation(1185,383);
        Obstaculo mesaDireita = new Obstaculo(62, 152);
        addObject(mesaDireita,1170,250);
        mesaDireita.setLocation(1167,250);
        Obstaculo geladeira = new Obstaculo(110, 119);
        addObject(geladeira,1132,123);
        geladeira.setLocation(1144,107);
        Obstaculo paredeSuperiorEsquerda = new Obstaculo(148, 12);
        addObject(paredeSuperiorEsquerda,382,86);
        paredeSuperiorEsquerda.setLocation(401,88);
        Obstaculo paredeSuperior = new Obstaculo(112, 16);
        addObject(paredeSuperior,706,85);
        paredeSuperior.setLocation(712,88);
        Obstaculo paredeSuperiorDireita = new Obstaculo(234, 12);
        addObject(paredeSuperiorDireita,966,91);
        paredeSuperiorDireita.setLocation(972,91);
    }
}