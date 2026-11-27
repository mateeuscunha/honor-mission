import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Essa classe representa o quartel: ambiente principal da segunda fase do jogo.
 * @author Mateus Cunha
 * @version 14/11/2026
 */
public class Quartel extends MundoJogo
{
    /**
     * Construtor para o quartel.
     */
    public Quartel()
    {    
        super(1000, 750);
        prepare();
    }
    
    /**
     * Retorna a passagem para a fase 3. Ajuda no desbloqueio com cartao.
     */
    public PassagemFase3 getPassagemFase3() {
        return this.getObjects(PassagemFase3.class).get(0);
    }
    
    /**
     * Prepara o mundo para o início do programa.
     * Ou seja: criar os objetos iniciais e adicioná-los ao mundo.
     */
    private void prepare()
    {
        escreverDica("Procure a entrada para o Museu", 185, getHeight() - 100);
        escreverDica("O cartão e a arma se encontrarão por lá", 218, getHeight() - 80);
        
        Jogador jogador = new Jogador();
        addObject(jogador, 250, 580);

        // adiciona os paineis, herda de MundoJogo
        adicionarPaineis();

        // Adicionando os viloes
        addObject(new Cachorro(), 223, 400);
        addObject(new Cachorro(), 336, 274);
        addObject(new Cachorro(), 443, 400);
        addObject(new Cachorro(), 727, 526);

        // Adicionando passagens
        Museu museu = new Museu(this);
        ReservaArmamento reserva = new ReservaArmamento();

        Passagem passagemMuseu = new Passagem(35, 60, museu, 875, 467);
        addObject(passagemMuseu, 80, 367);

        PassagemFase3 passagemReservaArmamento = new PassagemFase3(100, 58, reserva, 501, 606);
        addObject(passagemReservaArmamento, 400, 81);
        
        // Posicionando itens
        BotaoLaser botaoLaser = new BotaoLaser();
        addObject(botaoLaser,594,165);
        
        Radio radio = new Radio();
        addObject(radio, 237, 91);
        
        addObject(new Moeda(), 743, 94);
        addObject(new Moeda(), 114, 482);
        
        // Adicionando obstaculos
        Obstaculo paredeEsquerda = new Obstaculo(69, 750);
        addObject(paredeEsquerda,34,374);
        Obstaculo paredeBaixo = new Obstaculo(961, 89);
        addObject(paredeBaixo,545,704);
        Obstaculo paredeDireita = new Obstaculo(91, 750);
        addObject(paredeDireita,956,352);
        Obstaculo paredeCima = new Obstaculo(918, 50);
        addObject(paredeCima,483,23);
        Obstaculo diretaEntreAloja = new Obstaculo(34, 178);
        addObject(diretaEntreAloja,632,148);

        Obstaculo paredeSalinha = new Obstaculo(13, 217);
        addObject(paredeSalinha,504,147);
        Obstaculo caixasSalinha = new Obstaculo(73, 50);
        addObject(caixasSalinha,611,237);
        Obstaculo paredeEsqAloj = new Obstaculo(27, 185);
        addObject(paredeEsqAloj,636,318);

        Obstaculo infEsqAloj = new Obstaculo(52, 38);
        addObject(infEsqAloj,663,394);
        Obstaculo cimaSalinha = new Obstaculo(200, 56);
        addObject(cimaSalinha,549,73);
        Obstaculo cimaEsqQuartel = new Obstaculo(299, 60);
        addObject(cimaEsqQuartel,200,77);
        Obstaculo infDirAloj = new Obstaculo(184, 38);
        addObject(infDirAloj,830,396);
        Obstaculo cama1 = new Obstaculo(107, 53);
        addObject(cama1,856,153);
        Obstaculo cama2 = new Obstaculo(107, 53);
        addObject(cama2,856,240);
        Obstaculo cama3 = new Obstaculo(107, 53);
        addObject(cama3,856,332);
        Obstaculo banco1 = new Obstaculo(26, 75);
        addObject(banco1,110,274);
        Obstaculo banco2 = new Obstaculo(22, 75);
        addObject(banco2,110,456);

        Obstaculo caixas = new Obstaculo(74, 61);
        addObject(caixas,127,626);

        Obstaculo caixaSupEsq = new Obstaculo(35, 43);
        addObject(caixaSupEsq,108,135);
        Obstaculo caixaInfDir = new Obstaculo(36, 36);
        addObject(caixaInfDir,893,643);

        Obstaculo plantaAloj = new Obstaculo(103, 36);
        addObject(plantaAloj,705,107);

        Obstaculo caixaAloj = new Obstaculo(64, 34);
        addObject(caixaAloj,878,92);
        Obstaculo paredeCimaAloj = new Obstaculo(267, 52);
        addObject(paredeCimaAloj,778,63);

        Obstaculo mesaSalinha = new Obstaculo(29, 52);
        addObject(mesaSalinha,596,156);
        Obstaculo criado1 = new Obstaculo(24, 22);
        addObject(criado1,898,288);

        Obstaculo criado2 = new Obstaculo(24, 22);
        addObject(criado2,898,198);
    }
}
