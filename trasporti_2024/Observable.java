package it.uniud.poo.trasporti_2024;

/**
 * MISSION: provide the protocol for the observer pattern
 * This object is notified when the fleet changes
 * of when the bookings change
 */
public interface Observable {
    /**
     * add an observer to the list of observers
     * @param o
     */
    void addObserver(Observer o);
    /**
     * notify all observers
     */
    void notifyObservers();
}
