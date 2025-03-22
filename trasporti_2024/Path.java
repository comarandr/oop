package it.uniud.poo.trasporti_2024;

import lombok.NonNull;

import java.util.List;

/**
 * MISSION: to represent a path from a source to a destination. A path is a sequence of legs
 * such that the destination of a leg is the source of the next leg.
 * It is immutable.
 * <p>
 * INVARIANT: a path must have at least one leg. Two consecutive legs must be connected:
 * if leg1 and  leg2 are consecutive, then destination of leg1 should be equal to source of leg2.
 */
public class Path {
    private final List<PathLeg> legs;

    /**
     * creates a path with the given legs.
     *
     * @param legs the legs of the path. The destination of a leg must be the source of the next leg.
     * @throws IllegalArgumentException if this is not true: if
     *                                  leg1 and  leg2 are consecutive, then destination of leg1 should be equal to source of leg2.
     */
    public Path(@NonNull List<PathLeg> legs) {
        if (legs.size() < 1) {
            throw new IllegalArgumentException("A path must have at least two legs");
        }
        for (int i = 0; i < legs.size() - 1; i++) {
            PathLeg leg1 = legs.get(i);
            PathLeg leg2 = legs.get(i + 1);
            if (!leg1.getLocationA().equals(leg2.getLocationB())) {
                throw new IllegalArgumentException("The destination of a leg must be the source of the next leg");
            }
        }
        this.legs = legs;
    }

    public List<PathLeg> getLegs() {
        return legs;
    }

    /**
     * @return the total distance of the path, which is the sum of the distances of the legs.
     */
    public double calculateTotalDistance() {
        return legs.stream().mapToDouble(PathLeg::getDistanceKM).sum();
    }

    /**
     * @return the total basic cost of the path, which is the sum of the basic costs of the legs.
     */
    public double calculateBasicCost() {
        return legs.stream().mapToDouble(PathLeg::getBasicCost).sum();
    }

    /**
     * Extends the path with a new leg that starts from the destination of the last leg of the path.
     * @return a new path with the new leg added at the end.
     * @param destination not null and not empty
     * @param distance   in km
     * @param cost in euros
     * @throws IllegalArgumentException if origin is not equal to the destination of the last leg of the path or
     *                                  if origin or destination are null or empty
     */
    public Path extendPath(String destination, double distance, double cost) {
        PathLeg lastLeg = legs.get(legs.size() - 1);
        PathLeg leg = new PathLeg(distance, cost, lastLeg.getLocationB(), destination);
        List<PathLeg> existingLegs = getLegs();
        existingLegs.add(leg);
        return new Path(existingLegs);
    }

    public String getStartLocation() {
        return legs.get(0).getLocationA();
    }

    public String getEndLocation() {
        return legs.get(legs.size() - 1).getLocationB();
    }

    /**
     * 2 paths are equal if they have the same legs.
     * @param o the object to compare with
     * @return true if the paths are equal, false otherwise
     */
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Path)) return false;
        Path other = (Path) o;
        return this.legs.equals(other.legs);
    }

    /**
     * @return a hash code value for this path.
     * The hash code is computed from the legs of the path.
     */
    public int hashCode() {
        return legs.hashCode();
    }
}
