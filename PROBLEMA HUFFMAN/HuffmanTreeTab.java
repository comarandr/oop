import huffman_toolkit.*;
/**
 * Aggiungi qui una descrizione della classe HuffmanTree
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class HuffmanTreeTab{
    public static final int[] freq  = chrFreq();
    public static final Node root  = huffmanTree();
    public static final String[] HuffTable = huffmanTable();
    
        public static int[] chrFreq(){
        int[] freq = new int [InputTextFile.CHARS];
        InputTextFile in = new InputTextFile("ASCII.txt");
        
        for(int i = 0; i<128;i++){
            in.readTextLine();
            String val = in.readTextLine() ;
            int value = Integer.parseInt(val);
            freq[i] = value;
            in.readTextLine();
        
        }
        
        return freq;
    }
    
    public static Node huffmanTree (){
        NodeQueue queue = new NodeQueue();
        for(int c=0; c<freq.length; c=c+1){
            if(freq[c]>0){
                Node n = new Node ( (char) c, freq[c] );
                queue.add(n);
            }
        }
        
        while(queue.size()>1){
            Node l = queue.poll();
            Node r = queue.poll();
            Node n = new Node (l,r);
            queue.add(n);
        }
        
        return queue.poll();
    }
    
    //procedura che crea la tabella di huffman che associa carattere al peso
    public static String[] huffmanTable(){
        String[] tab = new String[InputTextFile.CHARS];
        fillTab(root,"",tab);
        return tab;
    }
    
    public static void fillTab(Node n, String hc, String[] tab){
       if(n.isLeaf() ){
           tab[n.symbol()] = hc;
       } else {
           fillTab(n.left(), hc + "0", tab); //compilo con uno 0 ogni spostamento a sx
           fillTab(n.right(),hc+ "1", tab); //compilo con un 1 ogni spostamento a dx
       }
    }
}
