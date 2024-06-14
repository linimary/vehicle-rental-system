package org.example;

public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected double value;
    protected Reservation reservation;
    protected long reserved;
    protected long elapsed;
    protected long remaining;

    public Vehicle(String brand, String model, double value, Reservation reservation) {
        this.brand = brand;
        this.model = model;
        this.value = value;
        this.reservation = reservation;
        calculatePeriods();
    }

    private void calculatePeriods() {
        this.reserved = reservation.calculateReservedDays();
        this.elapsed = reservation.calculateElapsedDays();
        this.remaining = reservation.calculateRemainingDays();
    }

    public abstract double getDailyRentalRate();

    public abstract double getDailyInsuranceRate();

    public abstract double difference();

    public abstract double totalInsurancePerDay();

    public double calculateTotalRent() {
        return getDailyRentalRate() * reserved - earlyDiscountRent();
    }

    public double calculateTotalInsurance() {
        return totalInsurancePerDay() * reserved - earlyDiscountInsurance();
    }

    public double getTotal() {
        return calculateTotalRent() + calculateTotalInsurance();
    }

    public double earlyDiscountRent() {
        return (getDailyRentalRate() / 2) * remaining;
    }

    public double earlyDiscountInsurance() {
        return totalInsurancePerDay() * remaining;
    }

    public abstract void getInvoiceDetails();
}
