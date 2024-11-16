package it.uniud.poo.compiti.saporiditerra2;

import java.util.*;

/**
 * Mission: Gestire l'allocazione di colture e le loro produzioni in un singolo filare
 * Conosce: le allocazioni correnti e lo storico delle produzioni
 * Sa fare: allocare colture, registrare produzioni, calcolare rese
 */
class Filare {
    private final Map<String, Double> allocazioniColture = new HashMap<>();
    private final List<Produzione> produzioni = new ArrayList<>();

    /**
     * Precondizioni:
     * - nomeColtura non null e non vuoto
     * - 0 < percentuale <= 100
     * Postcondizioni:
     * - La coltura viene allocata se c'è spazio sufficiente
     * @throws SaporiDiTerraException se non c'è spazio sufficiente
     */
    public void allocaColtura(String nomeColtura, double percentuale) throws SaporiDiTerraException {
        if (nomeColtura == null || nomeColtura.trim().isEmpty())
            throw new IllegalArgumentException("Il nome della coltura non può essere vuoto");
        if (percentuale <= 0 || percentuale > 100)
            throw new IllegalArgumentException("La percentuale deve essere tra 0 e 100");

        double percentualeOccupata = allocazioniColture.values().stream()
                                                              .mapToDouble(Double::doubleValue)
                                                              .sum();

        if (percentualeOccupata + percentuale > 100) {
            throw new SaporiDiTerraException(
                String.format("Spazio insufficiente nel filare. Disponibile: %.2f%%, Richiesto: %.2f%%",
                            100 - percentualeOccupata, percentuale));
        }

        allocazioniColture.put(nomeColtura, percentuale);
    }

    /**
     * Precondizioni:
     * - nomeColtura non null e presente nelle allocazioni
     * Postcondizioni:
     * - La coltura viene rimossa dalle allocazioni
     */
    public void terminaColtura(String nomeColtura) throws SaporiDiTerraException {
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

    public List<Produzione> getProduzioni() {
        return Collections.unmodifiableList(produzioni);
    }

    public Set<String> getColtureAllocate() {
        return Collections.unmodifiableSet(allocazioniColture.keySet());
    }
}