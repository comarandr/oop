package it.uniud.poo.trasporti_2024;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * MISSION: to represent a container for paths.
 * Only the paths that are stored here are considered valid for trips.
 */
public class PathRepository {

    private Set<Path> paths = new HashSet<>();

    /**
     * Adds a path to the repository.
     * Preconditions:
     * 1. The 'path' is not null.
     * 2. The 'path' is not already in the repository.
     * Postconditions:
     * 1. The 'path' is added to the repository.
     *
     * @param path The path to be added.
     */
    public void addPath(Path path) {
        paths.add(path);
    }

    public Path findPathByStartAndEndLocations(String startLocation, String endLocation) {
        return paths.stream()
                .filter(path -> path.getStartLocation().equals(startLocation) && path.getEndLocation().equals(endLocation))
                .findFirst()
                .orElse(null);
    }

    /**
     * Finds alternative paths that connect source and destination locations.
     *
     * @param startLocation The start location of the path.
     * @param endLocation   The end location of the path.
     * @return A list of suitable paths, possibly empty.
     */
    public List<Path> findAlternativePaths(String startLocation,
                                           String endLocation,
                                           Path currentPath) {
        return paths.stream()
                .filter(path -> path.getStartLocation().equals(startLocation) && path.getEndLocation().equals(endLocation))
                .filter(path -> !path.equals(currentPath))
                .collect(Collectors.toList());
    }

    public boolean isValidTrip(Trip trip) {
        Path path = findPathByStartAndEndLocations(trip.getOrigin(), trip.getDestination());
        return path != null;

    }
}