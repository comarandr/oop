package it.uniud.poo.trasporti_2024;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class MainClient {

    public static void main(String[] args) {
        API api = new API();
        TripFactory tripFactory = api.getTripFactory();

        Truck truck = tripFactory.createTruck("T1", "truck", 1.5);
        Client client = tripFactory
                .createClient("C1", "client", "address");

        Trip trip = tripFactory.createTrip("Udine", "Torino",
                LocalDateTime.of(2023, 4, 1, 8, 0),
                GoodsKind.BOXES, 100);
        TripBooking booking = null;
        try {
             booking = api.createBookingTrip(trip, client);
        } catch (InvalidTripArgument e) {
            System.out.println("The trip is not valid");
        } catch (NoTruckAvailableException e) {
            System.out.println("No truck available");
        }
        // now booking is a valid trip booking
        // that is stored in the system


        // Now queries

        QueryFactory<TripBooking> qf = new QueryFactory<>();
        // create a query based on a date
        Query<TripBooking> datePredicate =
                qf.createQuery(trp -> trp.getDepartureDate()
                        .equals(LocalDateTime.of(2023, 4, 1,8,0)));
        // create a query based on a start location
        Query<TripBooking> startLocationPredicate =
                qf.createQuery(trp -> trp.getStartPlace().equals("Udine"));
        // create a query based on a date and a start location
        Query<TripBooking> complexQuery =
                qf.createAndQuery(datePredicate, startLocationPredicate);
        Query<TripBooking> evenMoreComplexQuery =
                qf.createOrQuery(datePredicate, qf.createNotQuery(startLocationPredicate));

        Stream<TripBooking> results = api.findBookings(complexQuery);
        // now we print them out
        results.forEach(System.out::println);

        // Now rerouting of booking.
        // booking is the booking we retrieved above

        assert booking != null;
        List<Path> paths = api.findAlternativePaths(booking);
        Path selectedNewPath = paths.get(0);//for semplicity
        api.rerouteTrip(booking, selectedNewPath);

        // now the booking has a new path
        // and the booking manager has been updated
    }
}

