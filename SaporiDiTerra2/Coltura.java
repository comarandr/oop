package it.uniud.poo.compiti.saporiditerra2;

import lombok.Getter;

import java.time.LocalDate;

/**
 * Mission: rappresentare una coltura
 * DEVE SAPERE: che ortaggio viene coltivato, la quantità di ortaggio prodotta alla fine,
 * data di semina e data di raccolta e sua lunghezza assoluta in metri
 * Una coltura valida deve avere nome ortaggio, date e produzioni diverse da null
 *
 * DEVE SAPER FARE:
 * - fare raccolto,
 * NOTA adottiamo uguaglianza per identità
 */
public class Coltura {

    private final String nomeColtura;
    private final LocalDate dataSemina;
    private  LocalDate dataRaccolta = null;
    private @Getter double quantitaProdotta = 0;
    private @Getter double lunghezzaAssolutaInMetri;

    public Coltura(String nomeColtura, LocalDate dataSemina, double lunghezzaAssolutaInMetri) {
        this.nomeColtura = nomeColtura;
        this.dataSemina = dataSemina;
        this.lunghezzaAssolutaInMetri = lunghezzaAssolutaInMetri;
    }

//
//    public boolean equals(Object o) {
//        if (o == this) return true;
//        if (!(o instanceof Coltura)) return false;
//        Coltura c = (Coltura) o;
//        return (c.nomeColtura.equals(nomeColtura)) &&
//                (c.dataSemina.equals(dataSemina)) &&
//                (c.dataRaccolta.equals(dataRaccolta)) &&
//                (c.quantitaProdotta == quantitaProdotta);
//    }
//
//    public int hashCode() {
//        return nomeColtura.hashCode() + dataSemina.hashCode() + dataRaccolta.hashCode() + Double.hashCode(quantitaProdotta);
//    }

    /**
     * Postcondizioni:
     * - modifica la quantità di ortaggio prodotta e data di raccolta
     *
     * */
    public void registraProduzione(Float chiliRaccolta, LocalDate now) {
        quantitaProdotta = chiliRaccolta;
        dataRaccolta = now;
    }
}
