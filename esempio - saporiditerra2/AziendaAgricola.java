package it.uniud.poo.compiti.saporiditerra2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Mission: Gestire l'intera azienda agricola
 * Conosce: tutti gli appezzamenti e le operazioni possibili
 * Sa fare: operazioni di alto livello e coordinamento
 */
class AziendaAgricola {
    private final Map<Integer, Appezzamento> appezzamenti = new HashMap<>();
    private final AnalisiProduzioni analisiProduzioni = new AnalisiProduzioni();

    /**
     * Postcondizioni:
     * - Viene creato un nuovo appezzamento se non esiste
     * - Viene restituito l'appezzamento richiesto
     * - Viene sollevato IllegalArgumentException se il numero dell'appezzamento è <= 0
     */
    public Appezzamento ottieniAppezzamento(int numeroAppezzamento) throws ValoreIllegaleException {
        if (numeroAppezzamento <= 0)
            throw new ValoreIllegaleException("Il numero dell'appezzamento deve essere positivo");
        // k -> new Appezzamento(k) è una lambda che crea un nuovo appezzamento con il numero k
        return appezzamenti.computeIfAbsent(numeroAppezzamento, Appezzamento::new);
    }

    public Appezzamento ottieniAppezzamento2(int numeroAppezzamento) {
        if (numeroAppezzamento <= 0)
            throw new IllegalArgumentException("Il numero dell'appezzamento deve essere positivo");
        return appezzamenti.computeIfAbsent(numeroAppezzamento, Appezzamento::new);
    }

    /**
     * Precondizioni: nessuna
     * Postcondizioni:
     * - Restituisce statistiche aggiornate per tutte le colture
     */
    public Map<String, Double> ottieniStatisticheColture() {
        return analisiProduzioni.calcolaResaPerColtura(appezzamenti.values());
    }

    /**
     * Precondizioni:
     * - periodo > 0
     * Postcondizioni:
     * - Restituisce le produzioni aggregate per il periodo specificato
     */
    public Map<String, Double> ottieniProduzioniUltimoPeriodo(int giorni) {
        if (giorni <= 0)
            throw new IllegalArgumentException("Il periodo deve essere positivo");

        return analisiProduzioni.calcolaProduzioniPeriodo(
            appezzamenti.values(),
            LocalDate.now().minusDays(giorni),
            LocalDate.now()
        );
    }
}