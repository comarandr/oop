package it.uniud.poo.compiti.saporiditerra2;


import java.time.LocalDate;
import java.util.Objects;

/**
 * Mission: Rappresentare una singola produzione agricola con quantità e data
 * Conosce: kg prodotti, metri occupati, data di produzione
 * Sa fare: fornire informazioni sulla produzione e calcolare la resa al metro
 */
class Produzione {
    private final double chilogrammiProdotti;
    private final double metriCoperti;
    private final LocalDate dataProduzione;

    /**
     * Precondizioni:
     * - chilogrammiProdotti > 0
     * - metriCoperti > 0
     * - dataProduzione non null
     * Postcondizioni:
     * - Viene creato un oggetto Produzione immutabile
     */
    public Produzione(double chilogrammiProdotti, double metriCoperti, LocalDate dataProduzione) {
        if (chilogrammiProdotti <= 0) throw new IllegalArgumentException("I chilogrammi devono essere positivi");
        if (metriCoperti <= 0) throw new IllegalArgumentException("I metri devono essere positivi");
        Objects.requireNonNull(dataProduzione, "La data non può essere null");

        this.chilogrammiProdotti = chilogrammiProdotti;
        this.metriCoperti = metriCoperti;
        this.dataProduzione = dataProduzione;
    }

    public double getChilogrammiProdotti() { return chilogrammiProdotti; }
    public double getMetriCoperti() { return metriCoperti; }
    public LocalDate getDataProduzione() { return dataProduzione; }

    public  double calcolaResaAlMetro() {
        return chilogrammiProdotti / metriCoperti;
    }
}