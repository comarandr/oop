
import huffman_toolkit.*;
import java.util.*;
/**
 * Aggiungi qui una descrizione della classe Huffman
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class Huffman
{
    public static final int[] freq  = chrFreq();
    public static final Node root  = huffmanTree();
    public static final String[] HuffTable = huffmanTable();
    
    //1 passo: calcolo frequenza caratteri //non più necessario
        private static int[] chrFreq(){
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
        //costa i cara    
        private static int chrCount(String src){
        InputTextFile in = new InputTextFile(src);
        int count = 0;
            while(in.textAvailable() ){
            in.readChar();
            count = count + 1;
        
        }
        return count;
    }
    
    //2 passo calcolo NODI/ALBERI
    private static Node huffmanTree (){
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
    private static String[] huffmanTable(){
        
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
    
    //procedura di compressione con passaggio di albero
    public static void compress (String src, String dst){
        
        InputTextFile in = new InputTextFile(src);
        OutputTextFile out = new OutputTextFile(dst);
        out.writeTextLine(""+ chrCount(src));
        
        while(in.textAvailable() ){
            char c = in.readChar();
            out.writeCode(HuffTable[c]);
        }
        
        in.close();
        out.close();
    }
    
    //procedura di decompressione passaggio
    public static void decompress(String src, String dst){
        InputTextFile in = new InputTextFile(src);
        OutputTextFile out = new OutputTextFile(dst);
        int count = Integer.parseInt(in.readTextLine() ); 
        
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
    
    public static void textRandomizer (String dst){
        OutputTextFile out = new OutputTextFile(dst);
        for(int i=0; i<129;i++){
        char c = (char) ( 128*Math.random() ) ;
        out.writeChar(c);
        }
        out.close();
    }
    
    
    
}//end class