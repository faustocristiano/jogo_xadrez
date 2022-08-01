package projeto2;


/**
 * Classe que cria a peça Peão, herdando da super classe Pecas
 * 
 */

public class Peao extends Pecas  {
    

    public Peao(EnumCor cor, double x, double y, String figura) {
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
    public boolean validarMovimento(double xDestino, double yDestino){


                    if(super.getCor().equals(EnumCor.BRANCO)){                        
                        if(super.getX()==xDestino&&yDestino<=3){
                            if(yDestino>super.getY())
                            this.setY(yDestino);
                            this.setSelecionada(false);
                            return true;
                        }                      
                            

                    }else if(super.getCor().equals(EnumCor.PRETO)){
                        if(super.getX()==xDestino&&yDestino>=4){
                            if(yDestino<super.getY())
                            this.setY(yDestino);
                            this.setSelecionada(false);
                            return true;
                        }                      
                            

                    }             

                    return false;

    }
}                    

                    