package org.example;

import java.text.DecimalFormat;

public class Motorcycle extends Vehicle {
    private int riderAge;

    public Motorcycle(String brand,
                      String model,
                      int value,
                      Reservation reservation,
                      int riderAge) {
        super(brand, model, value, reservation);
        this.riderAge = riderAge;
    }

    @Override
    public double getDailyRentalRate() {
        return (reserved <= 7) ? 15.00 : 10.00;
    }

    @Override
    public double getDailyInsuranceRate() {
        return value * 0.0002;
    }

    @Override
    public double difference() {
        return (riderAge < 25) ? getDailyInsuranceRate() * 0.2 : 0;
    }

    @Override
    public double totalInsurancePerDay() {
        return getDailyInsuranceRate() + difference();
    }

    @Override
    public void getInvoiceDetails() {
        var df = new DecimalFormat("0.00");
        System.out.println("Insurance addition per day: $" + df.format(difference()));
    }
}
