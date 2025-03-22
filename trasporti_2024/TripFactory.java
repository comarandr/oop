package it.uniud.poo.trasporti_2024;

import java.time.LocalDateTime;
import java.util.List;

public class TripFactory {

    /**
     * Create a path given the origin, destination, distance and cost of its first leg.
     * The path will have only one leg and could be extended later.
     *
     * @param origin      the origin not null and not empty
     * @param destination the destination not null and not empty
     * @param distance    in k
     * @param cost        in euros
     * @return the created path
     */
    public Path createPath(String origin, String destination, double distance, double cost) {
        PathLeg leg = new PathLeg(distance, cost, origin, destination);
        return new Path(List.of(leg));
    }

    /**
     * Creates a Trip.
     *
     * @param source            the source of the trip, not null and not empty
     * @param destination       the destination of the trip, not null and not empty
     * @param departureDate the departure date of the trip, a valid date
     * @param goodsKind         the kind of goods to be transported
     * @param goodsQuantity     the quantity of goods to be transported, positive,
     *                          expressed in the unit of measure of the goods kind
     * @return the created trip
     * @throws IllegalArgumentException if source or destination are empty or
     *                                  goodsQuantity is not positive
     */
    public Trip createTrip(String source, String destination, LocalDateTime departureDate, GoodsKind goodsKind, int goodsQuantity) {
        return new Trip(source, destination, departureDate, goodsKind, goodsQuantity);
    }


    public Truck createTruck(String id, String type, double costMultiplier) {
        return new Truck(id, type, costMultiplier);
    }

    public Client createClient(String id, String name, String address) {
        return new Client(id, name, address);
    }
}
