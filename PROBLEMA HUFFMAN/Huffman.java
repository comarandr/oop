
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

    public static final Node root  = huffmanTree();
    public static final String[] HuffTable = huffmanTable();

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