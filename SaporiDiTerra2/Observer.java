package it.uniud.poo.compiti.saporiditerra2;

import java.util.UUID;

public interface Observer {

    /**
     * POST:
     * - aggiorna l'observer in modo da tener conto dei nuovi valori per il filare
     * - solleva IllegalArgumentException se mOccupati > lunghezza || mOccupati < 0 || lunghezza <= 0
     */
    public void update(UUID idfilare, Double mOccupati, Double lunghezza); //i metodi non devono avere body nelle interfacce
}
