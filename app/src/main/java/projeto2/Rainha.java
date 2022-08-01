package projeto2;

public class Rainha extends Pecas {

    public Rainha(EnumCor cor, double x, double y, String figura) {
        super(cor, x, y, figura);
    }

    @Override
    public boolean validarMovimento(double xDestino, double yDestino) {
                    this.setY(yDestino);
                    this.setX(xDestino);
                    this.setSelecionada(false);
        return true;
    }
    
}
