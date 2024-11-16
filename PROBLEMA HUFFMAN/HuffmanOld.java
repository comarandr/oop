
import huffman_toolkit.*;
/**
 * Aggiungi qui una descrizione della classe Huffman
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class HuffmanOld
{
    
    //1 passo: calcolo frequenza caratteri
    
    private static int[] chrFreq(String src){
        InputTextFile in = new InputTextFile(src);
        int[] freq = new int [InputTextFile.CHARS];
        for(int c=0;c<freq.length; c=c+1){
            freq[c]=0;
        }
        
        while(in.textAvailable() ){
            char c = in.readChar();
            freq [c] = freq[c]+1;
        }
        
        in.close();
        return freq;
    }
    
    //2 passo calcolo NODI/ALBERI
    private static Node huffmanTree (int[] freq){
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
    private static String[] huffmanTable(Node root){
        
        String[] tab = new String[InputTextFile.CHARS];
        fillTab(root,"",tab);
        return tab;
    }
    
    private static void fillTab(Node n, String hc, String[] tab){
       if(n.isLeaf() ){
           tab[n.symbol()] = hc;
       } else {
           fillTab(n.left(), hc + "0", tab); //compilo con uno 0 ogni spostamento a sx
           fillTab(n.right(),hc+ "1", tab); //compilo con un 1 ogni spostamento a dx
       }
    }
    

   
     //senza passaggio di albero, ma con HEAT (intestazione)
    public static void compress (String src, String dst){
        int[] freq = chrFreq(src);
        Node tree = huffmanTree(freq);
        String[] tab = huffmanTable(tree);
        
        InputTextFile in = new InputTextFile(src);
        OutputTextFile out = new OutputTextFile(dst);
        
        out.writeTextLine(""+tree.weight() );
        out.writeTextLine(flatTree(tree));
        
        while(in.textAvailable() ){
            char c = in.readChar();
            out.writeCode(tab[c]);
        }
        
        in.close();
        out.close(); 
    }
    
    //procedura di decompressione
    public static void decompress(String src, String dst){
        InputTextFile in = new InputTextFile(src);
        OutputTextFile out = new OutputTextFile(dst);
        int count = Integer.parseInt(in.readTextLine() );
        Node root = restoreTree(in);
        String dummy = in.readTextLine();
        
        for(int i=0;i<count;i=i+1){
            char c = restoreChar(in,root);
            out.writeChar(c);
        }
        in.close();
        out.close();
    }
    
    private static char restoreChar(InputTextFile in, Node n){
        do{
            int bit = in.readBit();
            if (bit == 0){
                n = n.left();
            } else {
                n = n.right();
            }
        }while(!n.isLeaf());
        
        return n.symbol();
    }
    
    private static String flatTree(Node n){
        if(n.isLeaf()){
            char c = n.symbol();
            if ( (c=='@') || (c == '\\') ){
                return "\\"+c;
            } else {
                return ""+c;
            }
        } else {
            return "@" + flatTree(n.left() ) + flatTree(n.right() );
        }
    }
    
    private static Node restoreTree(InputTextFile in){
        char c = in.readChar();
        if(c=='@'){
            Node l=restoreTree(in);
            Node r=restoreTree(in);
            return new Node(l,r);
        } else {
            if(c=='\\'){
                c=in.readChar();
            }
            return new Node(c,0);
        }
    }
}
