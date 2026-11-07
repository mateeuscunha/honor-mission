import greenfoot.*;
/**
 * Classe criada para os os elementos no mapa não serem atravessados pelo jogador;
 * 
 * @author (Gabriel Pedrozo && Mateus Cunha) 
 * @version (24/10)
 */
public class Obstaculo extends Actor
{
    /**
     * Construtor para obstaculos que colocam limites no mapa.
     */
    public Obstaculo(int largura, int altura)
    {
        GreenfootImage imagem = new GreenfootImage(largura, altura);
        //imagem.setTransparency(0);
        imagem.setColor(Color.RED);
        imagem.fill();
        setImage(imagem);
    }
    
    /**
     * Empurra para fora qualquer jogador ou vilao que esteja sobrepondo o obstaculo.
     */
    public void act()
    {
        for (Actor ator : getIntersectingObjects(Actor.class))
        {
            if (ator instanceof Jogador || ator instanceof Vilao)
            {
                expulsar(ator);
            }
        }
    }
    
        /**
     * Empurra o ator para fora do obstaculo, pelo lado mais proximo.
     */
    private void expulsar(Actor ator)
    {
        // 1. Tamanho real que o ator ocupa na tela (considerando a rotacao)
        int larguraAtor = calcularLarguraOcupada(ator);
        int alturaAtor = calcularAlturaOcupada(ator);

        // 2. Distancia entre o centro do ator e o centro do obstaculo
        int distanciaX = ator.getX() - this.getX();
        int distanciaY = ator.getY() - this.getY();

        // 3. Quanto o ator entrou no obstaculo em cada direcao
        int larguraObstaculo = getImage().getWidth();
        int alturaObstaculo = getImage().getHeight();

        int sobreposicaoX = (int) Math.ceil((larguraObstaculo/2.0) + (larguraAtor/2.0) - Math.abs(distanciaX));
        int sobreposicaoY = (int) Math.ceil((alturaObstaculo + alturaAtor) / 2.0 - Math.abs(distanciaY));

        // 4. So ha colisao se ele entrou nas duas direcoes ao mesmo tempo
        if (sobreposicaoX > 0 && sobreposicaoY > 0)
        {
            // 5. Empurra pela direcao em que entrou menos (o caminho mais curto)
            if (sobreposicaoX < sobreposicaoY)
            {
                empurrarNaHorizontal(ator, distanciaX, sobreposicaoX);
            }
            else
            {
                empurrarNaVertical(ator, distanciaY, sobreposicaoY);
            }
        }
    }

    /**
     * Empurra o ator para a direita ou para a esquerda.
     */
    private void empurrarNaHorizontal(Actor ator, int distanciaX, int sobreposicaoX)
    {
        int deslocamento = sobreposicaoX;   // por padrao, empurra para a direita

        if (distanciaX < 0)                 // se o ator esta a esquerda do centro...
        {
            deslocamento = -sobreposicaoX;  // ...empurra para a esquerda
        }

        ator.setLocation(ator.getX() + deslocamento, ator.getY());
    }

    /**
     * Empurra o ator para cima ou para baixo.
     */
    private void empurrarNaVertical(Actor ator, int distanciaY, int sobreposicaoY)
    {
        int deslocamento = sobreposicaoY;   // por padrao, empurra para baixo

        if (distanciaY < 0)                 // se o ator esta acima do centro...
        {
            deslocamento = -sobreposicaoY;  // ...empurra para cima
        }

        ator.setLocation(ator.getX(), ator.getY() + deslocamento);
    }

    /**
     * Largura do retangulo que envolve o ator ja girado.
     */
    private int calcularLarguraOcupada(Actor ator)
    {
        double angulo = Math.toRadians(ator.getRotation());
        double largura = ator.getImage().getWidth();
        double altura = ator.getImage().getHeight();

        double resultado = Math.abs(largura * Math.cos(angulo)) + Math.abs(altura * Math.sin(angulo));
        return (int) Math.round(resultado);
    }

    /**
     * Altura do retangulo que envolve o ator ja girado.
     */
    private int calcularAlturaOcupada(Actor ator)
    {
        double angulo = Math.toRadians(ator.getRotation());
        double largura = ator.getImage().getWidth();
        double altura = ator.getImage().getHeight();

        double resultado = Math.abs(largura * Math.sin(angulo)) + Math.abs(altura * Math.cos(angulo));
        return (int) Math.round(resultado);
    }
}