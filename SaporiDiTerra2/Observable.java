package it.uniud.poo.compiti.saporiditerra2;

public interface Observable {
    /**
     * aggiungi un osservatore senza duplicarlo
     * Se l'osservatore è già presente, solleva l'eccezione DuplicateObserverException
     * (importante, non fare nulla non va bene)
     * @param observer osservatore da aggiungere
     */
    void addObserver(Observer observer);


    /**
     *
     *
     */
    void notifyObservers();
}
