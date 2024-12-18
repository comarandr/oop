package Polimorfismo;

import java.util.Iterator;
import java.util.List;

public class ElencoPersone {
    List<Persona> list;
    int limit;

    public ElencoPersone(int limit){
        this.list = null;
        this.limit = limit;
    }

    /*
        post: se lista.size() < limite aggiunge p all'elenco;
        altrimenti solleva eccezione "limite raggiunto"
     */

    public void aggiungi(Persona p) throws OverflowException{
        if (this.list.size() + 1 > this.limit){
            throw new OverflowException();
        } else {
            this.list.add(p);
        }
    }

}
