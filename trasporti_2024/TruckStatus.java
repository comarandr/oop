package it.uniud.poo.trasporti_2024;

/**
 * used to represent the status of a truck in terms of its availability
 * ON_SITE: the truck is on site, available to be used for a trip
 * IN_TRIP: the truck is currently in a trip, not available for other trips
 *
 */
public enum TruckStatus {
    ON_SITE, IN_TRIP, UNDER_MAINTENANCE
}
