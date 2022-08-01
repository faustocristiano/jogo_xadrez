package projeto2;


/**
 * Classe que cria a peça Cavalo, herdando da super classe Pecas
 * 
 */

public class Cavalo extends Pecas{

    public Cavalo(EnumCor cor, double x, double y, String figura) {
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
                            
            if((xDestino==(super.getX()-1))&&(yDestino==(super.getY())+2)){                              
                this.setY(yDestino);
                this.setX(xDestino);
                this.setSelecionada(false);
                return true;

            }    
           else if((xDestino==(super.getX()+1))&&(yDestino==(super.getY())+2)){                              
                this.setY(yDestino);
                this.setX(xDestino);
                this.setSelecionada(false);
                return true;

            }                       
           else if((xDestino==(super.getX()-1))&&(yDestino==(super.getY())-2)){                              
                this.setY(yDestino);
                this.setX(xDestino);
                this.setSelecionada(false);
                return true;

            }    
           else if((xDestino==(super.getX()+1))&&(yDestino==(super.getY())-2)){                              
                this.setY(yDestino);
                this.setX(xDestino);
                this.setSelecionada(false);
                return true;

            }                                        
                this.setSelecionada(false);     
       

        return false;

    }
}
    

