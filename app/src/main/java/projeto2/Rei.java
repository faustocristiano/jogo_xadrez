package projeto2;


/**
 * Classe que cria a peça Rei, herdando da super classe Pecas
 * 
 */
public class Rei extends Pecas {

    public Rei(EnumCor cor, double x, double y, String figura) {
        super(cor, x, y, figura);
    }
     /**
     * 
     * Metodo que valida os movimentos do Cavalo
     * @param xDestino coordenada X de destino, herdada do click do mouse
     * @param yDestino coordenada Y de destino, herdada do click do mouse
     * 
     */
    @Override
    public boolean validarMovimento(double xDestino, double yDestino) {

                    if(super.getX()==xDestino&&(super.getY()==yDestino+1)){
                        this.setY(yDestino);
                        this.setSelecionada(false);
                        return true;
                    }
                    if(super.getX()==xDestino&&(super.getY()==yDestino-1)){
                        this.setY(yDestino);
                        this.setSelecionada(false);
                        return true;
                    }

                    if(super.getY()==yDestino&&(super.getX()==xDestino+1)){
                        this.setX(xDestino);
                        this.setSelecionada(false);
                        return true;
                    }
                    if(super.getY()==yDestino&&(super.getX()==xDestino-1)){
                        this.setX(xDestino);
                        this.setSelecionada(false);
                        return true;
                    }
                    
                    this.setSelecionada(false);

        return false;
    }
    
}
