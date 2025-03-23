package it.uniud.poo.trasporti_2024;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class API {
    private PathRepository pathRepository;
    private final Fleet fleet;
    private BookingManager bookingManager = new BookingManager(pathRepository);
    private final @Getter TripFactory tripFactory = new TripFactory();

    public API() {
        this.pathRepository = new PathRepository();
        this.bookingManager = new BookingManager(pathRepository);
        this.fleet = new Fleet();
        addPredefinedPaths();
        addTrucks();
    }

    /**
     * Adds some predefined paths to the path repository.
     */
    private void addPredefinedPaths() {
        Path path = tripFactory.createPath("Udine", "Trieste", 100, 100)
                .extendPath("Roma", 800, 500)
                .extendPath("Napoli", 200, 200)
                .extendPath("Palermo", 1000, 1000);

        Path anotherPath = tripFactory.createPath("Venezia", "Milano", 200, 200)
                .extendPath("Torino", 200, 200)
                .extendPath("Aosta", 100, 100);
        pathRepository.addPath(path);
        pathRepository.addPath(anotherPath);
    }

    private void addTrucks() {
        Truck truck = tripFactory.createTruck("T1", "truck", 1.5);
        Truck anotherTruck = tripFactory.createTruck("T2", "truck", 1.5);
        Truck yetAnotherTruck = tripFactory.createTruck("T3", "truck", 1.5);
        fleet.addTruck(truck);
        fleet.addTruck(anotherTruck);
        fleet.addTruck(yetAnotherTruck);
    }


    /**
     * Creates a trip booking for the given trip.
     * PRECONDITIONS:
     * The trip must be valid, i.e., it must have at least one valid path,
     * otherwise an InvalidTripArgument exception is thrown.
     * POSTCONDITIONS:
     * If no suitable trucks are available,
     * a NoTruckAvailableException is thrown.
     * Otherwise a trip booking is created and returned.
     * and is added to the booking manager.
     *
     * @param trip The trip to be booked.
     */
    public TripBooking createBookingTrip(@NonNull Trip trip, Client client)
            throws InvalidTripArgument, NoTruckAvailableException {
        if (pathRepository.isValidTrip(trip)) {
            throw new InvalidTripArgument("The trip must be valid");
        }
        Set<Truck> suitableTrucks = fleet.findSuitableTrucks(trip);
        if (suitableTrucks.isEmpty()) {
            throw new NoTruckAvailableException("No suitable truck available");
        }
        Set<Truck> availableTrucks = bookingManager.filterAvailableTrucks(trip, suitableTrucks);
        if (availableTrucks.isEmpty()) {
            throw new NoTruckAvailableException("No available truck available");
        }
        TripBooking tripBooking = bookingManager.createTripBooking(trip,
                availableTrucks.iterator().next(),
                client);
        bookingManager.addPlannedBooking(tripBooking);
        return tripBooking;
    }



    /**
     * find bookings that satisfy the given query
     *
     * @param qry the query to satisfy
     * @return a stream of bookings that satisfy the query
     */
    public Stream<TripBooking> findBookings(Query<TripBooking> qry) {
        return bookingManager.findBookings(qry);
    }
    /**
     * find alternative paths for the given trip booking
     * among the predefined ones and different from the current path
     *
     * @param tripBooking the trip booking
     * @return a list of alternative paths
     */
    public List<Path> findAlternativePaths(TripBooking tripBooking) {
        Trip trip = tripBooking.getTrip();
        if (trip == null) {
            throw new IllegalArgumentException("The trip must exist");
        }
        String startLocation = trip.getOrigin();
        String endLocation = trip.getDestination();
        Path currentPath = tripBooking.getPath();
        return pathRepository.findAlternativePaths(startLocation,
                endLocation, currentPath);
    }

    /**
     * modify the stored booking by setting the new path
     * @param booking the booking to change
     * @param selectedNewPath the new path to set
     */
    public void rerouteTrip(TripBooking booking, Path selectedNewPath) {
        bookingManager.updateTripPath(booking.getBookingID(), selectedNewPath);
    }
}