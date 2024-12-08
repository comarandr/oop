package it.uniud.poo.compiti.saporiditerra2;

import java.util.Iterator;

/**
 * MISSION: rappresenta un filare meccanizzabile dove le colture utilizzano almeno il 30%
 * della lunghezza totale del filare
  */
public class GrandeFilare extends Filare {

    /**
     * Precondizioni:
     * - nomeColtura non null e non vuoto
     * - 30 < percentuale <= 100
     * Postcondizioni:
     * - La coltura viene allocata se c'è spazio sufficiente
     * @throws SaporiDiTerraException se non c'è spazio sufficiente
     */
    public void allocaColtura(String nomeColtura, double percentuale) throws SaporiDiTerraException {
        if (nomeColtura == null || nomeColtura.trim().isEmpty())
            throw new IllegalArgumentException("Il nome della coltura non può essere vuoto");
        if (percentuale <= 30 || percentuale > 100)
            throw new IllegalArgumentException("La percentuale deve essere tra 30 e 100");

        super.allocaColtura(nomeColtura, percentuale);

    }
}
