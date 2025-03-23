package it.uniud.poo.trasporti_2024;

/**
 * MISSION: provide the protocol for the observer pattern
 * This object is notified when the fleet changes
 * of when the bookings change
 */
public interface Observer {

    /**
     * modify the state of the observer when the fleet changes
     * @param fleet
     */
    void update(Fleet fleet);
    /**
     * modify the state of the observer when the bookings change
     * @param bookings
     */
    void update(TripBooking bookings);
}
