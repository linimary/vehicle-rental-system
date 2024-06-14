package org.example;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Invoice {
    private Vehicle vehicle;
    private String customerName;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Invoice(Vehicle vehicle, String customerName) {
        this.vehicle = vehicle;
        this.customerName = customerName;
    }

    public void createInvoice() {
        System.out.println("XXXXXXXXXX");
        System.out.println("Date: " + LocalDate.now().format(dtf));
        System.out.println("Customer Name: " + customerName);
        System.out.println("Rented Vehicle: " + vehicle.brand + " " + vehicle.model);
        System.out.println(" ");
        System.out.println("Reservation start date: " + vehicle.reservation.getStart().format(dtf));
        System.out.println("Reservation end date: " + vehicle.reservation.getEnd().format(dtf));
        System.out.println("Reserved rental days: " + vehicle.reservation.calculateReservedDays() + " days");
        System.out.println(" ");
        System.out.println("Actual return date: " + vehicle.reservation.getReturned());
        System.out.println("Actual rental days: " + vehicle.reservation.calculateElapsedDays() + " days");
        System.out.println(" ");
        System.out.println("Rental cost per day: $" + df.format(vehicle.getDailyRentalRate()));

        if (vehicle.difference() != 0) {
            System.out.println("Initial insurance per day: $" + df.format(vehicle.getDailyInsuranceRate()));
            vehicle.getInvoiceDetails();
        }

        System.out.println("Insurance per day: $" + df.format(vehicle.totalInsurancePerDay()));
        System.out.println(" ");

        if (vehicle.remaining > 0) {
            System.out.println("Early return discount for rent: $" + df.format(vehicle.earlyDiscountRent()));
            System.out.println("Early return discount for insurance: $" + df.format(vehicle.earlyDiscountInsurance()));
            System.out.println(" ");
        }

        System.out.println("Total rent: $" + df.format(vehicle.calculateTotalRent()));
        System.out.println("Total insurance: $" + df.format(vehicle.calculateTotalInsurance()));
        System.out.println("Total: $" + df.format(vehicle.getTotal()));
        System.out.println("XXXXXXXXXX");
    }
}
