/**
 * classe che rappresenta i nodi/alberi
 */
public class Node implements Comparable<Node>{
    //variabili d'istanza
    private final char chr; //carattere
    private final int wgt; //peso
    private final Node lft; //nodo discendente sinistro
    private final Node rgt; //nodo discendente destro
   
    // 1 costruttore per i nodi singoli, che abbinano un carattere c al suo peso w
    public Node(char c, int w){  //nodo foglia
        chr = c;
        wgt = w;
        lft = null;
        rgt = null;
    }

    public Node (Node l, Node r){
        chr = (char) 0; //casting del tipo
        wgt = l.weight() + r.weight();
        lft = l;
        rgt = r;
    }
    
    public boolean isLeaf(){ //nodo è una foglia se non ha discendenti
        return (lft==null);
    }
    
    public char symbol(){
        return chr;
    }
    
    public Node left(){
        return lft;
    }
    
    public Node right(){
        return rgt;
    }
    
    public int weight(){
        return wgt;
    }
    
    public int compareTo(Node n){
        if(weight()<n.weight() ){
            return -1;
        } else if(weight() == n.weight() ){
            return 0;
        } else {
            return +1;
        }
    }
}//end class    

