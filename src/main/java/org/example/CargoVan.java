package org.example;

import java.text.DecimalFormat;

public class CargoVan extends Vehicle {
    private int driverExperience;

    public CargoVan(String brand,
                    String model,
                    int value,
                    Reservation reservation,
                    int driverExperience) {
        super(brand, model, value, reservation);
        this.driverExperience = driverExperience;
    }

    @Override
    public double getDailyRentalRate() {
        return (reserved <= 7) ? 50.00 : 40.00;
    }

    @Override
    public double getDailyInsuranceRate() {
        return value * 0.0003;
    }

    @Override
    public double difference() {
        return (driverExperience > 5) ? getDailyInsuranceRate() * 0.15 : 0;
    }

    @Override
    public double totalInsurancePerDay() {
        return getDailyInsuranceRate() - difference();
    }

    @Override
    public void getInvoiceDetails() {
        var df = new DecimalFormat("0.00");
        System.out.println("Insurance discount per day: $" + df.format(difference()));
    }
}
