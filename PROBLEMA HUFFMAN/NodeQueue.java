
/**
 * Aggiungi qui una descrizione della classe NodeQueue
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class NodeQueue
{
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private Node[] queue;

    /**
     * Costruttore degli oggetti di classe  NodeQueue
     */
    public NodeQueue() //costruttore coda vuota
    {
       queue = new Node[0];
    }

    public int size() //mi indica la lunghhezza della coda
    {
        return queue.length;   
    }
    
    public Node peek(){ //mi restituisce il nodo con il peso minore
        Node n = queue[0];
        for(int i = 1; i<size(); i++){
            if(n.weight() > queue[i].weight()){
                n = queue[i];
            }
        }
        return n;
    }
    
    public void add (Node n){ //aggiunge un nodo
        Node[] tmp = new Node[size()+1];
        
        for(int i = 0; i<size(); i++){
            tmp[i] = queue[i];
        }
        tmp[size()] = n;
        
        queue = tmp; 
    }
    
    public Node poll(){ //restituisce e toglie il nodo con il peso minore
        Node n = peek();
        Node[] tmp = new Node[size()-1];
        int i = 0;
        
        while(queue[i]!= n){
            tmp[i] = queue[i];
            i = i+1;
        }
        
        if (i==size()-1){
            queue = tmp;
        } else {
            for (int j = i+1; j<size(); j++){
                tmp[j-1] = queue[j];
            }
            queue = tmp;
        }
        return n;
    }
}
