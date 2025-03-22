package it.uniud.poo.trasporti_2024;

import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Manages the booking of trips.
 * <p>
 * Responsibilities:
 * - Keep track of planned, in-progress, and completed bookings.
 * - Transition bookings from planned to in-progress to completed.
 * - Add new bookings.
 * - Set paths for planned trips.
 * - Update paths for in-progress trips.
 * - Find available trucks for a trip.
 * <p>
 */
public class BookingManager {
    /**
     * CONCRETE State: the planned, in-progress, and completed bookings.
     * and the collection of predefined paths.
     * <p>
     * INVARIANT: a booking must be present at most in one of the three lists.
     * pathRepository must be not null and not empty.
     */
    private List<TripBooking> plannedBookings = new ArrayList<>();
    private List<TripBooking> inProgressBookings = new ArrayList<>();
    private List<TripBooking> completedBookings = new ArrayList<>();

    private PathRepository pathRepository;

    public BookingManager(PathRepository pathRepository) {
        this.pathRepository = pathRepository;
    }


    /**
     * Helper method to check if a booking already exists in the
     * planned bookings.
     *
     * @return the booking if the booking exists, null otherwise.
     */
    private boolean containsPlannedBooking(String bookingId) {


        TripBooking result = plannedBookings.stream()
                .filter(b -> b.getBookingID().equals(bookingId))
                .findFirst()
                .orElse(null);
        return result != null;
    }

    /**
     * Adds a new booking to the list of planned bookings.
     * <p>
     * Preconditions:
     * 1. The 'booking' must be a valid, non-null TripBooking instance.
     * 2. The 'booking' should not already exist in planned, in-progress, or completed bookings.
     * <p>
     * Postconditions:
     * 1. The 'booking' is added to the list of planned bookings.
     *
     * @param booking The new TripBooking to be added.
     */
    public void addPlannedBooking(@NonNull TripBooking booking) {
        // TODO check for uniqueness
        plannedBookings.add(booking);
    }



    // Helper method to find a booking by ID
    private TripBooking findBookingById(String bookingId, List<TripBooking> bookings) {
        return bookings.stream()
                .filter(b -> b.getBookingID().equals(bookingId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
    }

    /**
     * Sets a path for a planned trip.
     * <p>
     * Preconditions:
     * 1. The trip with the given 'tripId' exists in the planned bookings.
     * 2. The 'path' is a valid, non-null Path instance.
     * <p>
     * Postconditions:
     * 1. The trip's path is updated to the given path.
     *
     * @param tripId The ID of the trip.
     * @param path   The Path to be associated with the trip.
     */
    public void setTripPath(String tripId, Path path) {
        TripBooking trip = findBookingById(tripId, plannedBookings);
        trip.setPath(path);
    }

    /**
     * Updates the path for an in-progress trip.
     *
     * @param tripId  The ID of the trip to update.
     * @param newPath The new path for the trip.
     */
    public void updateTripPath(String tripId, Path newPath) {
        // Logic to find the trip by ID and update its path
    }

    /**
     * find the subset of suitable trucks that are available for the trip
     * i.e. that are not busy with other trips on that date
     *
     * @param trip
     * @param suitableTrucks
     * @return
     */
    public Set<Truck> filterAvailableTrucks(Trip trip,
                                            Set<Truck> suitableTrucks) {
        HashSet<Truck> results = new HashSet<Truck>();
        for (Truck truck : suitableTrucks) {
            if (!truckIsUsed(truck, trip.getDepartureDate())) {
                results.add(truck);
            }
        }
        return results;
    }

    /**
     * check if the truck is used on the given date
     *
     * @param truck         the truck to check
     * @param departureDate the date to check
     * @return true if the truck is used on the given date, false otherwise
     */
    private boolean truckIsUsed(@NonNull Truck truck,
                                @NonNull LocalDateTime departureDate) {
        TripBooking booking = plannedBookings.stream()
                .filter(bkng -> bkng.getTruck().equals(truck))
                .filter(bkng -> bkng.getTrip().getDepartureDate().equals(departureDate))
                .findFirst()
                .orElse(null);
        return booking != null;
    }

    public TripBooking createTripBooking(Trip trip, Truck truck, Client client) {
        TripBooking tripBooking = new TripBooking(trip, truck, client);
        addPlannedBooking(tripBooking);
        return tripBooking;
    }

    /**
     * extract all planned bookings that satisfy the given query
     *
     * @param query the query to satisfy
     * @return the stream of all planned bookings that satisfy the given query
     */
    public Stream<TripBooking> findBookings(Query<TripBooking> query) {
        return plannedBookings.stream().filter(query);
    }
}
