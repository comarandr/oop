package Polimorfismo;

public class ProvaListaPersone {

    public static void main(String[] a) throws OverflowException {
        Persona persona1 = new Persona( "CRNTIOSPOJ", "Carlo", "Rosselli" );
        System.out.println( persona1.toString() );
        Studente studente1 = new Studente("WOGJK","Alessio", "Rossi", 254522, "Udine");
        System.out.println( studente1.toString() );
        ElencoPersone elenco1 = new ElencoPersone( 4);
        elenco1.aggiungi(persona1);
        elenco1.aggiungi(persona1);
        elenco1.aggiungi(persona1);
        elenco1.aggiungi(persona1);
        elenco1.aggiungi(persona1);
    }



}
