package it.uniud.poo.trasporti_2024;

import java.util.List;

public class Dashboard implements Observer {
    @Override
    public void update(Fleet fleet) {
        displayTruckStatuses(fleet);
    }

    @Override
    public void update(TripBooking bookings) {
    // TODO: implement this method
    }


    private void displayTruckStatuses(Fleet fleet) {
        List<Truck> trucks = null; // todo: get trucks from fleet

        System.out.println("Trucks on site:");
        displayTrucks(trucks, TruckStatus.ON_SITE);

        System.out.println("Trucks currently in a trip:");
        displayTrucks(trucks, TruckStatus.IN_TRIP);

        System.out.println("Trucks under maintenance:");
        displayTrucks(trucks, TruckStatus.UNDER_MAINTENANCE);

        // Display total kilometers run this month
        displayTotalKilometersRunThisMonth(trucks);
    }

    private void displayTrucks(List<Truck> trucks, TruckStatus status) {
        trucks.stream()
                .filter(truck -> truck.getStatus() == status)
                .forEach(truck -> System.out.println(truck));
    }

    private void displayTotalKilometersRunThisMonth(List<Truck> trucks) {
        int totalKm = trucks.stream()
                .mapToInt(Truck::getKilometersRunThisMonth)
                .sum();
        System.out.println("Total kilometers run this month: " + totalKm);
    }
}
