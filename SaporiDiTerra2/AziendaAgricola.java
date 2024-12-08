package it.uniud.poo.compiti.saporiditerra2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Mission: Gestire l'intera azienda agricola
 * Conosce: tutti gli appezzamenti, le produzioni raccolte e la dashboard
 * Sa fare: operazioni di alto livello e coordinamento
 */
class AziendaAgricola {
    /*
    INVARIANTE:
    - dashboard è diverso da null
    - registroProduzioni è diverso da null
     */
    private final Map<Integer, Appezzamento> appezzamenti = new HashMap<>();
    private final AnalisiProduzioni analisiProduzioni = new AnalisiProduzioni();

    private final RegistroProduzioni registroProduzioni = new RegistroProduzioni();
// TODO verificare incapsulamento
    private Dashboard dashboard;

    public AziendaAgricola() {
        inizializzaDashboard();
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    private void inizializzaDashboard() {
        dashboard = new Dashboard(registroProduzioni);
//        dashboard.setRegistroProduzioni(registroProduzioni);
    }

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

    /**
     * Postcondizioni:
     * - libera lo spazio di filare occupato dalla coltura
     * - registra la produzione della coltura (chili raccolti e data di raccolta
     * - solleva eccezione SaporiDiTerraException se coltura non è presente nel filare
     */
    public void registraTerminazioneColtura(Coltura pom, Filare filare1, Float chiliRaccolta) throws SaporiDiTerraException{
        filare1.terminaColtura(pom);
        pom.registraProduzione(chiliRaccolta, LocalDate.now());
        registroProduzioni.registraProduzione(pom, filare1);

    }
}