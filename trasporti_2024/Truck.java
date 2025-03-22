package it.uniud.poo.trasporti_2024;

import lombok.Getter;
import lombok.NonNull;

/**
 * MISSION: to represent a truck that can be used to transport goods.
 * the truck has an id, a type (e.g. "van", "truck", "train") and a cost multiplier. it is immutable.
 * The cost multiplier is used to compute the cost of a path, and is applied to the basic cost of each leg.
 */
public class Truck {
    private final @Getter String id;
    private final @Getter String type;
    private @Getter double costMultiplier = 1.0;

    // Constructor, getters, and setters


    public Truck(@NonNull String id, @NonNull String type, double costMultiplier) {
        if (id.isEmpty() || type.isEmpty()) {
            throw new IllegalArgumentException("id and type should not be empty");
        }
        this.id = id;
        this.type = type;
        this.costMultiplier = costMultiplier;
    }

    /**
     * Creates a truck with the given id and type.
     *
     * @param id   the id of the truck, not null and not empty
     * @param type the type of the truck, not null and not empty
     * @throws IllegalArgumentException if id or type are null or empty
     */
    public Truck(@NonNull String id, @NonNull String type) {
        if (id.isEmpty() || type.isEmpty()) {
            throw new IllegalArgumentException("id and type should not be empty");
        }
        this.id = id;
        this.type = type;
    }

    /**
     * @param cost the basic cost of a leg
     * @return the cost of the leg, which is the basic cost multiplied by the cost multiplier of the truck.
     */
    public double applyCostMultiplier(double cost) {
        return cost * costMultiplier;
    }

    /**
     * @param goodsKind
     * @param goodsQuantity
     * @return true if the truck is suitable for transporting the given goods kind and quantity
     */
    public boolean isSuitableForGoods(GoodsKind goodsKind, double goodsQuantity) {
        // TODO: implement this method
        return false;
    }

    public TruckStatus getStatus() {
        return null;
    }// TODO

    public int getKilometersRunThisMonth() { // TODO
        return 0;
    }
}