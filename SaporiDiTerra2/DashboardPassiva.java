package it.uniud.poo.compiti.saporiditerra2;

import java.util.UUID;

//se introduco interfaccia, devo implementare metodi dell'interfaccia
public class DashboardPassiva implements Observer {
    /**
     * Mission: produrre informazioni su occupazione del terreno e sulla produzione
     * per sapere cosa passare alla dashoard bisogna capire come vogliamo utilizzarla
     * stato astratto:
     *
     * cosa conosce:
     * - conosce i filari per cui è arriavata la notifica
     * - per ogni filare conosce la sua lunghezza totale e il num totale di metri occupati
     * - per ogni ortaggio, per il periodo che va da inizio anno, quale sia il numero di chili raccolti
     *
     * cosa sa fare:
     * - sa produrre per un dato filare il n. assoluto di metri occupati e liberi
     * - darmi il num totale di metri occupati e liberi tra tutti i filari
     * - quantità totale prodotta per ogni ortaggio (meglio, le colture sono strutturate per gestione, più che reporting)
     * - per ogni ortaggio, per il periodo che va da inizio anno, quale sia il numero di chili raccolti
     * - produrre per un dato ortaggio il num totale di chili raccolti da inizio anno
     * - produrre il totale di tutti gli ortaggi
     * - sa azzerare i dati per marcare inizio anno
     */

    /**
     * STATO ASTRATTO:
     *
     * duplichiamo i dati, ma tramite gestione observer, i dati sono aggiornati. Qua in uso reporting
     * di là per uso di gestione, per cui ridondanza giustificata ma ben gestita (uso corretto del pattern)
     *
     *
     * mappa da id filare --> (metri occupati, lunghezze di filare)
     */


    /**
     * STATO CONCRETO
     *
     * @return
     */

    private Map<UUID, Double> mappaMOccupati = new HashMap<>();
    private Map<UUID, Double> mappaLunghezza = new HashMap<>();

    /**
     * INVARIANTE DI RAPPRESENTAZIONE:
     * - per ogni k: 0<= mappa metri occupati(k) <= mappa lunghezza(k)
     * il fatto che la lunghezza dei filari sia fissa NON fa parte dell'invariante di rappresentazione di questa classe
     * - per ogni k: mappalunghezza(k) > 0
     * - se k è una chiave in mappaMOccupati, allora k è una chiave in mappaLunghezza. e viceversa
     * - va bene anche mappa vuota
     */

    /*
     * POST: restituisce il n. di m occupati del filare indicato
     * solleva eccezione IllegalArgumentException se non esiste il filare con idFilare dentro la dashboard
     */
    public double ottieniMetriOccupati(UUID idfilare){
        if mappaMOccupati.containsKey(idfilare){
            return mappaMOccupati.get(idfilare);
        }
        throw new IllegalArgumentException("chiave del filare non esistente");

    }

    /*
     * POST: restituisce il n. di m liberi del filare indicato
     * solleva eccezione IllegalArgumentException se non esiste il filare con idFilare dentro la dashboard
     */

    //TODO scrivere il contratto prima di consegnare
    public double ottieniMetriLiberi(UUID idfilare){
        if mappaLunghezza.containsKey(idfilare){ //non serve doppio controllo, invariante
            return mappaLunghezza.get(idfilare) - mappaMOccupati.get(idfilare);
        }
        throw new IllegalArgumentException("chiave del filare non esistente");
    }
    //alternativamente

    /*POST: restituisce il n. di m liberi del filare indicato
     * solleva eccezione IllegalArgumentException se non esiste il filare con idFilare dentro la dashboard
     */
    public double ottieniMetriLiberiB(UUID idfilare){
        Double mo = ottieniMetriOccupati(idfilare);
        return (mappaLunghezza.get(idfilare)) - mo;
    }





    /*
     * POST: restituisce la domma dei metri occupati di tutti i filari presenti
     */
    public double ottieniMetriOccupatiTotali(){
        //possibilità di convertire in set con dei metodi e iterare su di esso
        //Double x = mappaLunghezza.values().stream().mapToDouble(Double::doubleValue).sum();
        double totale = 0D;
        for (Double d : mappaMOccupati.values()){
            totale = totale + d;
        }
        return totale;
    }

    /*
     * POST:
     */
    public double ottieniMetriLiberiTotali(){
        //TODO
        return 0;
    }


    @override

    public void update(UUID idfilare, Double mOccupati, Double lunghezza){
        if ((mOccupati > lunghezza) || (mOccupati < 0) || (lunghezza <= 0)){
            throw new IllegalArgumentException("metri occupati ???");
        }
        mappaMOccupati.put(idfilare,mOccupati);
        mappaLunghezza.put(idfilare, lunghezza);
    }
}
