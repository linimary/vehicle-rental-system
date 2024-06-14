package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Car
        var carReservation = new Reservation(
                LocalDate.of(2024, 6, 3),
                LocalDate.of(2024, 6, 13));
        carReservation.setReturned(LocalDate.of(2024, 6, 13));
        var car = new Car("Mitsubishi", "Mirage", 15_000, carReservation, 3);
        var carInvoice = new Invoice(car, "John Doe");
        carInvoice.createInvoice();

        // Motorcycle
        var motorcycleReservation = new Reservation(
                LocalDate.of(2024, 6, 3),
                LocalDate.of(2024, 6, 13));
        motorcycleReservation.setReturned(LocalDate.of(2024, 6, 13));
        var motorcycle = new Motorcycle("Triumph", "Tiger Sport 660", 10_000, motorcycleReservation, 20);
        var motorcycleInvoice = new Invoice(motorcycle, "Mary Johnson");
        motorcycleInvoice.createInvoice();

        // Cargo Van
        var cargoVanReservation = new Reservation(
                LocalDate.of(2024, 6, 3),
                LocalDate.of(2024, 6, 18));
        cargoVanReservation.setReturned(LocalDate.of(2024, 6, 13));
        var cargoVan = new CargoVan("Citroen", "Jumper", 20_000, cargoVanReservation, 8);
        var cargoVanInvoice = new Invoice(cargoVan, "John Markson");
        cargoVanInvoice.createInvoice();
    }
}