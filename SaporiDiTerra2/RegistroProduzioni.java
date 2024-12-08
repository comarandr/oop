package it.uniud.poo.compiti.saporiditerra2;

/*
COSA SA: le colture raccolte da sempre,
contiene solo le colture tc coltura.eStataRaccolta() = true

COSA SA FARE:
- sa registrare una coltura
- sa produrre elenco delle sue colture
 */

import java.util.Iterator;

public class RegistroProduzioni {
    /*
    post-condizioni:
    - aggiunge la coltura al registro insieme al filare, purché non sia duplicata
    - solleva eccezione ? se duplicata
    - solleva eccezione ? se coltura non è stata raccolta
     */
    public void registraProduzione(Coltura coltura, Filare filare) {
    }

    /*
    post-condizioni: ritorna iteratore su tutte le colture raccolte
     */
    public Iterator<Coltura> iterator() {
        return null;
    }
    /* NOTA lo deleghiama a qualche altra classe

    calcolaResa(appezzamento)
    calcolaResa(filare)
    calcolaResa(Coltura)
    calcolaResa(periodo) per tutta l'azienda
    calcolaResa(periodo, filare|appezzamento|coltura) per la cosa specifca nel periodo
     */
}
