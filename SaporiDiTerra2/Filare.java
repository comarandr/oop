package it.uniud.poo.compiti.saporiditerra2;

import java.util.*;

/**
 * Mission: Gestire l'allocazione di colture e le loro produzioni in un singolo filare
 * Conosce: le allocazioni correnti e lo storico delle produzioni,
 * Sa fare: allocare colture, registrare produzioni, calcolare rese
 */
class Filare {
    private final Map<Coltura, Double> allocazioniColture = new HashMap<>();
    private final List<Produzione> produzioni = new ArrayList<>();

    /**
     * Funzione di astrazione:
     * allocazioniColture contiene le colture attualmente allocate nel filare,
     * con le rispettive percentuali
     *
     * produzioni contiene le produzioni passate del filare
     */

    /**
     * INVARIANTE di rappresentazione:
     * - allocazioniColture != null
     * - allocazioniColture non contiene chiavi null
     * - allocazioniColture non contiene valori null
     * - allocazioniColture contiene valori 0 <= x <= 100
     * - la somma delle percentuali di allocazioniColture è <= 100
     * - produzioni != null
     * - produzioni non contiene valori null
     * - produzioni non contiene duplicati
     * - produzioni non contiene valori con data di inizio maggiore di quella di fine
     * - produzioni non contiene valori con quantità <= 0
     *
     */

    /**
     * Postcondizioni:
     * - La coltura viene allocata se c'è spazio sufficiente, altrimenti solleva un'eccezione SaporiDiTerraException
     * - calcola la lunghezza ssoluta della coltura e lo memorizza in coltura
     * - solleva IllegalArgumentException se percentuale <= 0 o percentuale > 100
     * - solleva IllegalArgumentException se coltura è null
     * - solleva SaporiDiTerraException se la coltura è già presente
     * @throws SaporiDiTerraException se non c'è spazio sufficiente
     */
    public void allocaColtura(Coltura coltura, double percentuale) throws SaporiDiTerraException {
        /*
            valida la percentuale e valida la coltura, solleva le relative eccezioni
            controlla la percentuale in modo che non superi il 100%
            controlla che la coltura non sia già presente; altrimenti solleva SaporiDiTerraException
            alloca la coltura con la sua percentuale
         */




        if (nomeColtura == null || nomeColtura.trim().isEmpty())
            throw new IllegalArgumentException("Il nome della coltura non può essere vuoto");
        if (percentuale <= 0 || percentuale > 100)
            throw new IllegalArgumentException("La percentuale deve essere tra 0 e 100");

        double percentualeOccupata = allocazioniColture.values().stream()
                                                              .mapToDouble(Double::doubleValue)
                                                              .sum();
        Iterator<Double> it = allocazioniColture.values().iterator();
        while (it.hasNext()) {
            percentualeOccupata += it.next();
        }
        assert percentualeOccupata >= 0 && percentualeOccupata <= 100;

        if (percentualeOccupata + percentuale > 100) {
            throw new SaporiDiTerraException(
                String.format("Spazio insufficiente nel filare. Disponibile: %.2f%%, Richiesto: %.2f%%",
                            100 - percentualeOccupata, percentuale));
        }

        allocazioniColture.put(nomeColtura, percentuale);
    }

    /**
     * Postcondizioni:
     * - La coltura viene rimossa dalle allocazioni e lo spazio viene liberato
     * - solleva SaporiDiTerraException se la coltura non è presente
     */
    public void terminaColtura(Coltura coltura) throws SaporiDiTerraException {
        if (!allocazioniColture.containsKey(nomeColtura)) {
            throw new SaporiDiTerraException("Coltura non presente nel filare: " + nomeColtura);
        }
        allocazioniColture.remove(nomeColtura);
    }

    /**
     * Precondizioni:
     * - nomeColtura non null e presente nelle allocazioni
     * - produzione non null
     * Postcondizioni:
     * - La produzione viene registrata
     */
    public void registraProduzione(String nomeColtura, Produzione produzione) throws SaporiDiTerraException {
        if (!allocazioniColture.containsKey(nomeColtura)) {
            throw new SaporiDiTerraException("Coltura non presente nel filare: " + nomeColtura);
        }
        Objects.requireNonNull(produzione, "La produzione non può essere null");
        produzioni.add(produzione);
    }

    public double getPercentualeAllocata(String nomeColtura) {
        return allocazioniColture.getOrDefault(nomeColtura, 0.0);
    }

    public Iterator<Produzione> getProduzioniIterator() {
        return produzioni.iterator();
    }


    public Collection<Object> getProduzioni() {
        return null;
    }
}