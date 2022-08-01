package projeto2;



public abstract class Pecas {
    private double x; //coluna
    private double y;//linha
    private boolean selecionada;
    private EnumCor cor;
    private boolean eliminada;
    private String figura;
    private Tabuleiro tabuleiro;

    public Pecas(EnumCor cor,double x, double y,String figura) {
        this.x = Math.floor(x);
        this.y = Math.floor(y);
        this.selecionada = false;
        this.eliminada=false;
        this.cor=cor;
        this.figura=figura;
        
    }

  
    public abstract boolean validarMovimento(double xDestino,double yDestino);
 
   

    public void marcaDesmarca() {
        this.selecionada = ! this.selecionada;
    }

  
    public boolean isSelecionada() {
        return selecionada;
    }

    public void setSelecionada(boolean selecionada) {
        this.selecionada = selecionada;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    public double getX() {
        return x;
    }

    public EnumCor getCor() {
        return cor;
    }

    public void setCor(EnumCor cor) {
        this.cor = cor;
    }

    public boolean isEliminada() {
        return eliminada;
    }
    

    public void setEliminada(boolean eliminada) {
        this.eliminada = true;
    }

    public void setX(double x) {        
        this.x = Math.floor(x);
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = Math.floor(y);
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}