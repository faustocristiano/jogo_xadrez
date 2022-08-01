package projeto2;
import java.util.ArrayList;


/**
 * Classe que cria o tabuleiro, 
   responsavel por instanciar as pecas no tabuleiro, organizalas,
   alterar a vez do jogador, consultar determinada peça mna casa,
   e se a casa esta livre. também, executa a eliminação da peça, 

 * 
 */
public class Tabuleiro {
  
    private EnumCor jogador;
    private ArrayList<Pecas>pecas;
    private final String  PEAO_BRANCO="peaob.png";
    private final String  TORRE_BRANCO="torreb.png";
    private final String  CAVALO_BRANCO="cavalob.png";
    private final String  BISPO_BRANCO="bispob.png";
    private final String  RAINHA_BRANCO="rainhab.png";
    private final String  REI_BRANCO="reib.png";
    private final String  PEAO_PRETO="peaop.png";
    private final String  TORRE_PRETO="torrep.png";
    private final String  CAVALO_PRETO="cavalop.png";
    private final String  BISPO_PRETO="bispop.png";
    private final String  RAINHA_PRETO="rainhap.png";
    private final String  REI_PRETO="reip.png";
    private boolean selecionada;
   
    

    /**
     * Metodo tabuleiro, instancia as peças na ordem correta do do jogo de xadrez
       e adiciona em uma lista 
     */
    public Tabuleiro (){
        jogador= EnumCor.BRANCO; 
        this.pecas=new ArrayList<Pecas>();
        for(int i=0;i<=7;i++){
            pecas.add(new Peao(EnumCor.BRANCO, i,1 , PEAO_BRANCO));
        }
        pecas.add(new Torre(EnumCor.BRANCO, 0, 0, TORRE_BRANCO));
        pecas.add(new Torre(EnumCor.BRANCO, 7, 0, TORRE_BRANCO));
        pecas.add(new Cavalo(EnumCor.BRANCO, 1, 0, CAVALO_BRANCO));
        pecas.add(new Cavalo(EnumCor.BRANCO, 6, 0, CAVALO_BRANCO));
        pecas.add(new Bispo(EnumCor.BRANCO, 2, 0, BISPO_BRANCO));
        pecas.add(new Bispo(EnumCor.BRANCO, 5, 0, BISPO_BRANCO));
        pecas.add(new Rainha(EnumCor.BRANCO, 3, 0, RAINHA_BRANCO));
        pecas.add(new Rei(EnumCor.BRANCO, 4, 0, REI_BRANCO));
        for(int i=0;i<=7;i++){
            pecas.add(new Peao(EnumCor.PRETO, i,6 , PEAO_PRETO));
        }
        pecas.add(new Torre(EnumCor.PRETO, 0, 7,TORRE_PRETO));
        pecas.add(new Torre(EnumCor.PRETO, 7, 7, TORRE_PRETO));
        pecas.add(new Cavalo(EnumCor.PRETO, 1, 7,CAVALO_PRETO));
        pecas.add(new Cavalo(EnumCor.PRETO, 6, 7, CAVALO_PRETO));
        pecas.add(new Bispo(EnumCor.PRETO, 2, 7, BISPO_PRETO));
        pecas.add(new Bispo(EnumCor.PRETO, 5, 7, BISPO_PRETO));
        pecas.add(new Rainha(EnumCor.PRETO, 3, 7, RAINHA_PRETO));
        pecas.add(new Rei(EnumCor.PRETO, 4, 7, REI_PRETO));      
        
    }
    /**
     * Metodo criado para alternancia das jogadas
     */
    public void alteraJogador(){
        if(this.jogador.equals(EnumCor.BRANCO))this.jogador=EnumCor.PRETO;
        else if(this.jogador.equals(EnumCor.PRETO))this.jogador=EnumCor.BRANCO;        
        this.selecionada=false;

    }

    /**
     * Metodo responsavel pela coonsulta de determinada casa no tabuleiro
       se as coordenadas da casa, coincidir com as coordenadas passadas
       pelo mouse como parametro, marca a peça 
     * @param x coordenada X,  do click do mouse
     * @param y coordenada Y,  do click do mouse
     * 
     */
    
    public boolean consultaCasa(double x,double y){        
        for(Pecas P: pecas){        
            if(P instanceof Peao){
                if(((Peao)P).getX()==Math.floor(x)&&((Peao)P).getY()==Math.floor(y)){ 
                      ((Peao)P).marcaDesmarca();                       
                        break;                  
                    }                  
                }
            
            else if(P instanceof Torre){
                    if(((Torre)P).getX()==Math.floor(x)&&((Torre)P).getY()==Math.floor(y)){ 
                        ((Torre)P).marcaDesmarca();
                        break;                                          
                    }
                }
            else if(P instanceof Bispo){
                    if(((Bispo)P).getX()==Math.floor(x)&&((Bispo)P).getY()==Math.floor(y)){                   
                        ((Bispo)P).marcaDesmarca(); 
                        break; 
                    }
                } 
            else if(P instanceof Rei){
                    if(((Rei)P).getX()==Math.floor(x)&&((Rei)P).getY()==Math.floor(y)){                   
                        ((Rei)P).marcaDesmarca();
                        break;                
                    }
                } 
            else if(P instanceof Rainha){
                    if(((Rainha)P).getX()==Math.floor(x)&&((Rainha)P).getY()==Math.floor(y)){                   
                        ((Rainha)P).marcaDesmarca();
                        break;                      
                    }
                }
            else if(P instanceof Cavalo){
                    if(((Cavalo)P).getX()==Math.floor(x)&&((Cavalo)P).getY()==Math.floor(y)){                   
                        ((Cavalo)P).marcaDesmarca();
                        break;                        
                    }
                }                                 
            }
        
            return true;
              
        } 
         
    
         /**
     * Metodo responsavel por receber as coordenadas de destino,
       de determinada casa no tabuleiro. repassa as cordendas para a Peca responsavel
       validar se o movimento é de acordo com aquela peça permite.
        Também, chama o metodo elimina, caso haja peça ca casa de destino
     * @param x coordenada X,  do click do mouse
     * @param y coordenada Y,  do click do mouse
     * 
     */
    
    public boolean movimentar(double xDestino,double yDestino){
        for(Pecas P: pecas){        
            if(P instanceof Peao){
                if(((Peao)P).isSelecionada()){
                    elimina(((Peao)P).getCor(),xDestino,yDestino); 
                    ((Peao)P).validarMovimento(Math.floor(xDestino), Math.floor(yDestino)); 
                    
                    alteraJogador(); 
                    break;                    
                    }                   
                }
            else if(P instanceof Torre){
                    if(((Torre)P).isSelecionada()){  
                        elimina(((Torre)P).getCor(),xDestino,yDestino); 
                        ((Torre)P).validarMovimento(Math.floor(xDestino), Math.floor(yDestino)); 
                        
                        alteraJogador(); 
                        break;                                  
                    }                        
                }
            else if(P instanceof Bispo){
                    if(((Bispo)P).isSelecionada()){ 
                            
                        ((Bispo)P).validarMovimento(Math.floor(xDestino), Math.floor(yDestino)); 
                        elimina(((Bispo)P).getCor(),xDestino,yDestino); 
                        alteraJogador();  
                        break;                                   
                    }                        
                } 
            else if(P instanceof Rainha){
                    if(((Rainha)P).isSelecionada()){  
                        elimina(((Rainha)P).getCor(),xDestino,yDestino); 
                        ((Rainha)P).validarMovimento(Math.floor(xDestino), Math.floor(yDestino));
                        
                        alteraJogador(); 
                        break;                               
                       }
                    }   
            else if(P instanceof Rei){
                    if(((Rei)P).isSelecionada()){
                        elimina(((Rei)P).getCor(),xDestino,yDestino); 
                        ((Rei)P).validarMovimento(Math.floor(xDestino), Math.floor(yDestino));
                        
                        alteraJogador();
                        break;                   
                    } 
                }       
            else if(P instanceof Cavalo){
                        if(((Cavalo)P).isSelecionada()){  
                            elimina(((Cavalo)P).getCor(),xDestino,yDestino);     
                            ((Cavalo)P).validarMovimento(Math.floor(xDestino), Math.floor(yDestino));  
                            
                            alteraJogador();
                            break;  
                        } 
                    }
             }
            return true;
        }    

   /**
    * Metodo criado para eliminar as peças
    * @param cor verificar de a cor peça de destino é igual da origem
    * @param xDestino oordenada X destino,  do click do mouse
    * @param yDestino oordenada y destino,  do click do mouse
    * @return
    */
    public boolean elimina(EnumCor cor,double xDestino,double yDestino){
        for(Pecas P: pecas){           
            
                if(P.getX()==Math.floor(xDestino)&&P.getY()==Math.floor(yDestino)){
                    if(cor==P.getCor()){break;}                
                    {
                        this.pecas.remove(P);  
                        P.setEliminada(true);               
                        return true;
                    }
                }             
            }
              
        
        return true;
        
    }


   
    public ArrayList<Pecas>Pecas(){
        return this.pecas;

    }
    public boolean isSelecionada() {
        return selecionada;
    }
   
    public void setSelecionada(boolean selecionada) {
        this.selecionada = selecionada;
    }   
   

    public void marcaDesmarca() {
        this.selecionada = ! this.selecionada;
    }   
  
}
