package it.uniud.poo.compiti.saporiditerra2;

import java.util.HashMap;
import java.util.Map;

/**
 * Mission: Gestire un insieme di filari e fornire statistiche aggregate
 * Conosce: i filari che lo compongono e la loro disposizione
 * Sa fare: operazioni aggregate sui filari e calcoli statistici
 */
class Appezzamento {
    private final int numero;
    private final Map<Integer, Filare> filari = new HashMap<>();

    public Appezzamento(int numero) {
        if (numero <= 0) throw new IllegalArgumentException("Il numero dell'appezzamento deve essere positivo");
        this.numero = numero;
    }

    public void aggiungiFilare(int numeroFilare, Filare filare) {
        if (numeroFilare <= 0)
            throw new IllegalArgumentException("Il numero del filare deve essere positivo");
        filari.putIfAbsent(numeroFilare, filare);
    }

    /**
     * Postcondizioni:
     * - Viene creato un nuovo filare se non esiste
     * - Viene restituito il filare richiesto
     * - Viene sollevato IllegalArgumentException se il numero del filare è <= 0
     */
    public Filare ottieniFilare(int numeroFilare) {
        if (numeroFilare <= 0)
            throw new IllegalArgumentException("Il numero del filare deve essere positivo");
        return filari.computeIfAbsent(numeroFilare, k -> new Filare());
    }

    public void aggiuntiColtura(int numeroFilare, String nomeColtura, double percentuale) throws SaporiDiTerraException {
        Filare filare = ottieniFilare(numeroFilare);
        filare.allocaColtura(nomeColtura, percentuale);
    }
//
//    /**
//     * Calcola la resa media dell'appezzamento su tutte le colture
//     */
//    public double calcolaResaMedia() {
//        return filari.values().stream()
//            .flatMap(f -> f.getProduzioni().stream())
//            .mapToDouble(Produzione::calcolaResaAlMetro)
//            .average()
//            .orElse(0.0);
//    }

    public int getNumero() { return numero; }
}