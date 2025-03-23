package it.uniud.poo.trasporti_2024;

import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * MISSION: represent a trip booking which consists of a trip that is
 * booked for a specific client.
 * The trip may be valid or not, depending on whether it has at least one
 * valid path.
 * Thus a valid TripBooking is a tuple <Trip, Client, Path>.
 */
public class TripBooking {
    /**
     * INVARIANT: the trip is not null, the client is not null.
     * The path may be null if no path has been set yet.
     */
    private @Getter final Trip trip; // The trip that is booked
    private @Getter @NonNull String bookingID; // The booking id
    private @Getter Path path;
    private @Getter Client client;
    private @Getter Truck truck;

    public TripBooking(@NonNull Trip trip, @NonNull Truck truck, @NonNull Client client) {
        this.trip = trip;
        bookingID = UUID.randomUUID().toString();
        this.truck = truck;
        this.client = client;
    }

    public boolean isValid() {
        return path != null;
    }

    /**
     * set the path of the trip booking.
     * @throws IllegalArgumentException if the path is null or if the path
     * does not start from the origin of the trip and does not end in the
     * destination of the trip.
     * @param path the path to set
     */
    public void setPath(@NonNull Path path) {
        if (!path.getStartLocation().equals(trip.getOrigin()) ||
            !path.getEndLocation().equals(trip.getDestination())) {
            throw new IllegalArgumentException("The path must start from the origin and end in the destination of the trip");
        }
        this.path = path;
    }

    public LocalDateTime getDepartureDate() {
        return trip.getDepartureDate();
    }

    public String getStartPlace() {
        return trip.getOrigin();
    }
    public String getEndPlace() {
        return trip.getDestination();
    }

    public String toString() {
        return "TripBooking(" + bookingID + ", " + trip + ", " + path + ")";
    }
}
