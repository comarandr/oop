package it.uniud.poo.trasporti_2024;

import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;

/**
 * MISSION: to represent a fleet of trucks, which is a collection of trucks without duplicates.
 * It is observable: it notifies its
 * observers when a truck changes its status.
 */
public class Fleet extends ObservableImpl {
    /**
     * CONCRETE State: the trucks of the fleet which must be not null
     * and a list of observers which must be not null
     */
    private @NonNull Set<Truck> trucks = new HashSet<>();
    /**
     * Method to notify all observers, which should have a notify() method
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    /**
     * Creates a fleet with the given trucks.
     *
     * @param trucks the trucks of the fleet. Must be non-null and not empty.
     * @throws IllegalArgumentException if trucks is empty.
     */
    public Fleet(@NonNull Set<Truck> trucks) {
        if (trucks.isEmpty()) {
            throw new IllegalArgumentException("A fleet must have at least one truck");
        }
        this.trucks = trucks;
        this.observers = new ArrayList<>();
    }

    public Fleet() {
        this.trucks = new HashSet<>();
        this.observers = new ArrayList<>();
    }



    /**
     * find the truck with that ID if it exists, otherwise return null
     *
     * @param truckId the ID of the truck to find
     * @return the truck with that ID if it exists, otherwise return null
     */
    public Truck getTruckById(@NonNull String truckId) {
        return this.trucks.stream()
                .filter(truck -> truck.getId().equals(truckId))
                .findFirst()
                .orElse(null);
    }



    /**
     * Finds a suitable and available truck for given goods and date.
     * TODO FIX this
     * */
    public Optional<Truck> findSuitableAndAvailableTruck(GoodsKind goods,
                                                            double quantity) {
        return trucks.stream() // TODO FIX this
                .filter(truck -> truck.isSuitableForGoods(goods, quantity))
                .findFirst();
    }


    /**
     * add a truck to the fleet
     */
    public void addTruck(Truck truck) {
        this.trucks.add(truck);
    }

    /**
     * extract the set of trucks that are suitable for the given trip
     * based on the goods to be transported
     * @param trip
     * @return the set of trucks that are suitable for the given kind and
     * quantity of goods to be transported, possibly empty
     */
    public Set<Truck> findSuitableTrucks(Trip trip) {
        Set<Truck> results = new HashSet<>();
        for (Truck truck : trucks) {
            if (truck.isSuitableForGoods(trip.getGoodsKind(), trip.getGoodsQuantity())) {
                results.add(truck);
            }
        }
        return results;
    }
}
