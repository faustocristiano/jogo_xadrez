package projeto2;

public class Bispo extends Pecas {

    public Bispo(EnumCor cor, double x, double y, String figura) {
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
