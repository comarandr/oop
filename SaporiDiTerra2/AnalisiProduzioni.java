package it.uniud.poo.compiti.saporiditerra2;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Mission: Fornire statistiche e analisi aggregate su produzioni e rese
 * Conosce: criteri di analisi e metodi di calcolo
 * Sa fare: calcolare statistiche e aggregazioni sui dati di produzione
 */
class AnalisiProduzioni {
    /**
     * Precondizioni:
     * - appezzamenti non null
     * - nessun elemento null nella collezione
     * Postcondizioni:
     * - Restituisce la resa media per ogni coltura
     */
    public Map<String, Double> calcolaResaPerColtura(Collection<Appezzamento> appezzamenti) {
        Objects.requireNonNull(appezzamenti, "La collezione di appezzamenti non può essere null");
//
//        return appezzamenti.stream()
//            .flatMap(app -> app.ottieniFilare(1).getColtureAllocate().stream())
//            .distinct()
//            .collect(Collectors.toMap(
//                coltura -> coltura,
//                coltura -> calcolaResaMediaColtura(appezzamenti, coltura)
//            ));
        return null;
    }

    /**
     * Precondizioni:
     * - appezzamenti non null
     * - intervallo non null
     * Postcondizioni:
     * - Restituisce le produzioni aggregate nel periodo specificato
     */
    public Map<String, Double> calcolaProduzioniPeriodo(
            Collection<Appezzamento> appezzamenti,
            LocalDate inizio,
            LocalDate fine) {
        Objects.requireNonNull(appezzamenti, "La collezione di appezzamenti non può essere null");
        Objects.requireNonNull(inizio, "La data di inizio non può essere null");
        Objects.requireNonNull(fine, "La data di fine non può essere null");

        if (fine.isBefore(inizio)) {
            throw new IllegalArgumentException("La data di fine non può precedere la data di inizio");
        }
//
//        return appezzamenti.stream()
//            .flatMap(app -> app.ottieniFilare(1).getColtureAllocate().stream())
//            .distinct()
//            .collect(Collectors.toMap(
//                coltura -> coltura,
//                coltura -> calcolaProduzioneColturaPeriodo(appezzamenti, coltura, inizio, fine)
//            ));
        return null;
    }

    private double calcolaResaMediaColtura(Collection<Appezzamento> appezzamenti, String coltura) {
        return 0.0;
//        return appezzamenti.stream()
//            .flatMap(app -> app.ottieniFilare(1).getProduzioni().stream())
//            .mapToDouble(Produzione::calcolaResaAlMetro)
//            .average()
//            .orElse(0.0);
    }

    private double calcolaProduzioneColturaPeriodo(
            Collection<Appezzamento> appezzamenti,
            String coltura,
            LocalDate inizio,
            LocalDate fine) {
//        return appezzamenti.stream()
//            .flatMap(app -> app.ottieniFilare(1).getProduzioni().stream())
//            .filter(p -> !p.getDataProduzione().isBefore(inizio) &&
//                        !p.getDataProduzione().isAfter(fine))
//            .mapToDouble(Produzione::getChilogrammiProdotti)
//            .sum();
    return  0.0;
    }
}
