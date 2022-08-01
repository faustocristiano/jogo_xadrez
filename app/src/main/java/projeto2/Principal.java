package projeto2;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;


/**
 * Classe Principal ,responsavel por desenhar o tabuleiro,
   inserir as peças de ordem correta, e redesenhar a tela,
   conforme peças são eliminadas
 */
public class Principal implements DrawListener {
    private final int DIMENSAO;    
    private Draw draw;   
    private final double DESLOCAR=0.5;
    Tabuleiro tabuleiro=new Tabuleiro();
   
  
    public Principal(int dimensao) {
        draw = new Draw();
      
        draw.addListener(this);
        this.DIMENSAO = dimensao;
        draw.setXscale(0, dimensao);
        draw.setYscale(0, dimensao);
        draw.enableDoubleBuffering();

        // Desenhando os objetos na tela
        desenharTela(-5,-5);
    }

     /**
     * Limpa a tela, desenha o tabuleiro e as peças
     */
    public void desenharTela(double x,double y){
        draw.clear(Color.WHITE);
        this.desenharTabuleiro(x,y);        
      
        
        this.desenharPecas();
        draw.show();
    }

    /**
     * Desenha a grade do tabuleiro pinta as casas conforme ordem do tabuleiro de xadrez
     */
    public void desenharTabuleiro(double xs,double ys){
        draw.setPenColor(Color.GRAY);
     
        for (int i = 0; i <= DIMENSAO; i++) {
            draw.line(i, 0, i, DIMENSAO);
            if(i%2==0){
                for(int y=0;y<=DIMENSAO;y++){
                    if(y%2==0){
                        draw.filledRectangle(i+DESLOCAR, y+DESLOCAR, DESLOCAR, DESLOCAR);
                    }
                }
            }
            if(i%2==1){
                for(int y=0;y<=DIMENSAO;y++){
                    if(y%2==1){
                        draw.filledRectangle(i+DESLOCAR, y+DESLOCAR, DESLOCAR, DESLOCAR);
                    }
                }
            }
        }
        
        for (int j = 0; j <= DIMENSAO; j++){
            draw.line(0, j, DIMENSAO, j);
        }

        //criado para marcar a casa selecionada pelo mouse
        if (xs != -5 && ys!=-5){
            draw.setPenColor(Color.GREEN);
            draw.filledRectangle(xs+DESLOCAR, ys+DESLOCAR, DESLOCAR, DESLOCAR);
        }

       
    
    }

    /**
     * Insere as peças na ordem correta do xadrez no tabuleiro
     */
    public void desenharPecas(){     

        for(Pecas P: tabuleiro.Pecas()){
            if(P instanceof Peao){
                if(((Peao)P).getCor().equals(EnumCor.BRANCO)){
                    if(!((Peao)P).isEliminada()) draw.picture(((Peao)P).getX()+DESLOCAR, ((Peao)P).getY()+DESLOCAR, ((Peao)P).getFigura());

                    
                }
                else if(((Peao)P).getCor().equals(EnumCor.PRETO)){
                    if(!((Peao)P).isEliminada()) draw.picture(((Peao)P).getX()+DESLOCAR, ((Peao)P).getY()+DESLOCAR, ((Peao)P).getFigura());

                }
            }
            if(P instanceof Torre){
                if(((Torre)P).getCor().equals(EnumCor.BRANCO)){
                    if(!((Torre)P).isEliminada()) draw.picture(((Torre)P).getX()+DESLOCAR, ((Torre)P).getY()+DESLOCAR, ((Torre)P).getFigura());

                }
                else if(((Torre)P).getCor().equals(EnumCor.PRETO)){
                    if(!((Torre)P).isEliminada()) draw.picture(((Torre)P).getX()+DESLOCAR, ((Torre)P).getY()+DESLOCAR, ((Torre)P).getFigura());

                }
            }
            if(P instanceof Bispo){
                if(((Bispo)P).getCor().equals(EnumCor.BRANCO)){
                    if(!((Bispo)P).isEliminada()) draw.picture(((Bispo)P).getX()+DESLOCAR, ((Bispo)P).getY()+DESLOCAR, ((Bispo)P).getFigura());

                }
                else if(((Bispo)P).getCor().equals(EnumCor.PRETO)){
                    if(!((Bispo)P).isEliminada()) draw.picture(((Bispo)P).getX()+DESLOCAR, ((Bispo)P).getY()+DESLOCAR, ((Bispo)P).getFigura());

                }
            }
            if(P instanceof Rei){
                if(((Rei)P).getCor().equals(EnumCor.BRANCO)){
                    if(!((Rei)P).isEliminada()) draw.picture(((Rei)P).getX()+DESLOCAR, ((Rei)P).getY()+DESLOCAR, ((Rei)P).getFigura());

                }
                else if(((Rei)P).getCor().equals(EnumCor.PRETO)){
                    if(!((Rei)P).isEliminada()) draw.picture(((Rei)P).getX()+DESLOCAR, ((Rei)P).getY()+DESLOCAR, ((Rei)P).getFigura());

                }
            }
            if(P instanceof Rainha){
                if(((Rainha)P).getCor().equals(EnumCor.BRANCO)){
                    if(!((Rainha)P).isEliminada()) draw.picture(((Rainha)P).getX()+DESLOCAR, ((Rainha)P).getY()+DESLOCAR, ((Rainha)P).getFigura());

                }
                else if(((Rainha)P).getCor().equals(EnumCor.PRETO)){
                    if(!((Rainha)P).isEliminada()) draw.picture(((Rainha)P).getX()+DESLOCAR, ((Rainha)P).getY()+DESLOCAR, ((Rainha)P).getFigura());

                }
            }
            if(P instanceof Cavalo){
                if(((Cavalo)P).getCor().equals(EnumCor.BRANCO)){
                    if(!((Cavalo)P).isEliminada()) draw.picture(((Cavalo)P).getX()+DESLOCAR, ((Cavalo)P).getY()+DESLOCAR, ((Cavalo)P).getFigura());

                }
                else if(((Cavalo)P).getCor().equals(EnumCor.PRETO)){
                    if(!((Cavalo)P).isEliminada()) draw.picture(((Cavalo)P).getX()+DESLOCAR, ((Cavalo)P).getY()+DESLOCAR, ((Cavalo)P).getFigura());

                }
            }
        }
      
    }

   

    /**
     * Captura o evento de botão pressionado do mouse
     * @param x coordenada X do cursor do mouse quando o botão foi pressionado
     * @param y coordenada Y do cursor do mouse quando o botão foi pressionado
     */
    public void mousePressed(double x, double y) {
            if(this.tabuleiro.isSelecionada()){
                tabuleiro.movimentar(x, y);
                tabuleiro.setSelecionada(false);              
                desenharTela(Math.floor(x),Math.floor(y));
            }else if(this.tabuleiro.consultaCasa(x, y)){
                this.tabuleiro.setSelecionada(true);
              
             }
    }


    public static void main(String[] args) {
        Principal p = new Principal(8);
    }


    // Métodos da interface DrawListener que não serão usados neste exemplo
    @Override
    public void mouseDragged(double v, double v1) {}
    @Override
    public void mouseReleased(double v, double v1) {}
    @Override
    public void mouseClicked(double v, double v1) {}
    @Override
    public void keyTyped(char c) {}
    @Override
    public void keyPressed(int i) {}
    @Override
    public void keyReleased(int i) {}
}