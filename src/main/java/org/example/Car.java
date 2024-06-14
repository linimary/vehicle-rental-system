package org.example;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    private int safetyRating;

    public Car(String brand,
               String model,
               int value,
               Reservation reservation,
               int safetyRating) {
        super(brand, model, value, reservation);
        this.safetyRating = safetyRating;
    }

    @Override
    public double getDailyRentalRate() {
        return (reserved <= 7) ? 20.00 : 15.00;
    }

    @Override
    public double getDailyInsuranceRate() {
        return value * 0.0001;
    }

    @Override
    public double difference() {
        return (safetyRating >= 4) ? getDailyInsuranceRate() * 0.9 : 0;
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
