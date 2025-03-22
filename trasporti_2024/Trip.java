package it.uniud.poo.trasporti_2024;

import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

/**
 * MISSION: represent a trip that some unspecified client might want to book.
 * A trip has a source location, a destination location, a departure date and
 * the goods to be transported. Quantity is expressed in a unit of measure
 * that is specific for the kind of goods (eg liters for liquids, tons for solids, etc.).
 */
public class Trip {
    /**
     * INVARIANT: each of the fields is not null and non empty
     * and the date is valid
     * and  origin != destination and goodsQuantity > 0.
     */

    private @Getter String origin;
    private @Getter String destination;
    private @Getter LocalDateTime departureDate;
    private @Getter GoodsKind goodsKind;
    private @Getter double goodsQuantity;

    /**
     * Creates a trip.
     *
     * @param origin        the origin of the trip
     * @param destination   th
     * @param departureDate t
     * @param goodsKind     the kind of goods to be transported
     * @param goodsQuantity the quantity of goods to be transported
     * @throws IllegalArgumentException if origin or destination are empty or
     *                                  goodsQuantity is not positive
     */
    public Trip(@NonNull String origin, @NonNull String destination,
                @NonNull LocalDateTime departureDate,
                GoodsKind goodsKind, double goodsQuantity) {
        if (origin.isEmpty() || destination.isEmpty()) {
            throw new IllegalArgumentException("Origin and destination must be non empty");
        }
        if (goodsQuantity <= 0) {
            throw new IllegalArgumentException("Goods quantity must be positive");
        }
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.goodsKind = goodsKind;
        this.goodsQuantity = goodsQuantity;
    }

    public String toString() {
        return "Trip from " + origin + " to " + destination + " on " + departureDate + " with " + goodsQuantity + " " + goodsKind;
    }
}