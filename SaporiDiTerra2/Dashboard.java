package it.uniud.poo.compiti.saporiditerra2;

import java.util.Iterator;

/**
 * Mission: rappresentare il dashboard dell'azienda
 * DEVE SAPERE: quale sia il registro produzioni dell'azienda
 * DEVE SAPER FARE:
 * - produrre risultati produzione per appezzamento, coltura, periodo temporale
 * - produrre risultati resa al metro o produzione totale per coltura, periodo temporale
 * - aggiornarsi in base ai dati del registro produzioni
 */
public class Dashboard {

    private RegistroProduzioni registroProduzioni;

    public Dashboard(RegistroProduzioni registroProduzioni) {
        this.registroProduzioni = registroProduzioni;
    }

    /**
     * post-condizione:
     * - restituisce chili totali dell'appezzamento su tutte le colture per il periodo che va
     * da sempre fino ad oggi
     * - solleva IllegalArgumentException se l'appezzamento non esiste
     */
    public Double calcolaResaAppezzamenti(int appezzamento) {
    }


    /**
     * post-condizione:
     * - restituisce chili totali di tutti gli appezzamenti,
     * di tutte le colture per il periodo che va da sempre fino ad oggi
     * - casomai 0
     */
    public Double calcolaResaAppezzamenti() {
    }

    /**
     * post-condizione:
     * - restituisce chili totali dell'appezzamento su tutte le colture per il periodo specificato
     * - solleva IllegalArgumentException se l'appezzamento non esiste
     * - solleva IllegalArgumentException se non esiste coltura con quel nome
     */
    public Double calcolaResaAppezzamenti(int appezzamento, String coltura, Periodo periodo) {
    }

    /**
     * post-condizione:
     * - restituisce chili totali e per metro di tutte le colture per il periodo specificato
     */
    public ResaDTO calcolaResaColture() {
        Iterator<Coltura> it = registroProduzioni.iterator();
        double quantitaAssoluta = 0;
        double metriTotali = 0;
        while (it.hasNext()) {
            Coltura c = it.next();
            quantitaAssoluta += c.getQuantitaProdotta();
            metriTotali += c.getLunghezzaAssolutaInMetri();
        }
        return new ResaDTO(quantitaAssoluta, quantitaAssoluta / metriTotali);
    }

    /**
     * post-condizione:
     * - restituisce chili totali e per metro della coltura specificata per il periodo che va da sempre fino ad oggi
     * - solleva IllegalArgumentException se non esiste la coltura o se non è stata raccolta
     */
    public ResaDTO calcolaResaColture(Coltura coltura) {
        Iterator<Coltura> it = registroProduzioni.iterator();
        double quantitaAssoluta = 0;
        double metriTotali = 0;
        boolean trovata = false;
        while (it.hasNext() && !trovata) {
            Coltura c = it.next();
            if (c.equals(coltura)) {
                quantitaAssoluta = c.getQuantitaProdotta();
                metriTotali = c.getLunghezzaAssolutaInMetri();
                trovata = true;
            }
        }
        if (!trovata) {
            throw new IllegalArgumentException("Coltura non presente");
        }
        return new ResaDTO(quantitaAssoluta, quantitaAssoluta / metriTotali);
    }

    /**
     * post-condizione:
     * - restituisce chili totali e per metro della coltura specificata
     * - solleva IllegalArgumentException se non esiste la coltura
     */
    public ResaDTO calcolaResaColture(String nomeColtura) {
    }

    /**
     * post-condizione:
     * - restituisce chili totali e per metro della coltura specificata per il periodo specificato
     * - solleva IllegalArgumentException se non esiste la coltura
     */
    public ResaDTO calcolaResaColture(String nomeColtura, Periodo periodo) {
    }
}
