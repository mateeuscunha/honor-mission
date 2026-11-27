import greenfoot.*;

/**
 * Botão que retorna da coleção para a tela de vitória.
 *
 * @author Gabriel Pedrozo
 * @version 26/11/2026
 */
public class BotaoVoltarColecao extends Botao
{
    private World telaAnterior;

    public BotaoVoltarColecao(World telaAnterior)
    {
        super("sair_vitoria.png");
        this.telaAnterior = telaAnterior;
    }

    @Override
    public void aoClicar()
    {
        Greenfoot.setWorld(telaAnterior);
    }
}
