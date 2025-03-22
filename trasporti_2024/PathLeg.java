package it.uniud.poo.trasporti_2024;

import lombok.Getter;
import lombok.NonNull;

/**
 * Mission: to represent a leg of a path, which is a connection between two locations.
 * It is characterized by a distance in km and a basic cost, and is symmetric.
 */
public class PathLeg {
    private  @Getter double distanceKM;
    private @Getter double basicCost;
    private @Getter String  locationA;
    private @Getter String locationB;

    /**
     * Creates a path leg.
     *
     * @param distanceKM the distance in km
     * @param basicCost  the basic cost
     * @param locationA  the first location, should be different from locationB and not null and not empty
     * @param locationB  the second location, should be different from locationA and not null and not empty
     * @raises IllegalArgumentException if locationA and locationB are equal or empty
     */
    public PathLeg(double distanceKM, double basicCost, @NonNull String locationA, @NonNull String locationB) {
        this.distanceKM = distanceKM;
        this.basicCost = basicCost;
        if (locationA.equals(locationB)) {
            throw new IllegalArgumentException("locationA and locationB should be different");
        }
        if (locationA.isEmpty() || locationB.isEmpty()) {
            throw new IllegalArgumentException("locationA and locationB should not be empty");
        }
        this.locationA = locationA;
        this.locationB = locationB;
    }
}