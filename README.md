# Rental Invoice Generator CLI App

This Java CLI application calculates and generates a rental invoice for various types of vehicles (car, motorcycle, and cargo van) based on predefined business rules. The invoice is generated automatically at the time of returning the rented vehicle without requiring user input during the interaction.

## Functionality

- **Vehicle Types:** Supports three types of vehicles: car, motorcycle, and cargo van.
- **Rental Information:** Requires vehicle brand, model, value, and additional specifics based on the vehicle type:
  - For cars: safety rating (1-5).
  - For motorcycles: rider's age.
  - For cargo vans: driver's experience in years.
- **Rental Period:** Calculates the number of days the vehicle was rented.
- **Cost Calculation:** Calculates rental and insurance costs based on specified parameters and business rules.
- **Output:** Displays the rental invoice with all calculations presented in currency format with two decimal places.

## Business Rules

- **Daily Rental Cost:**
  - Cars: $20 if rented for a week or less, $15 if rented for more than a week.
  - Motorcycles: $15 if rented for a week or less, $10 if rented for more than a week.
  - Cargo vans: $50 if rented for a week or less, $40 if rented for more than a week.
  
- **Insurance Cost per Day:**
  - Cars: 0.01% of vehicle value.
  - Motorcycles: 0.02% of vehicle value.
  - Cargo vans: 0.03% of vehicle value.

- **Insurance Adjustments:**
  - Cars: 10% reduction for high safety ratings (ratings 4 and 5).
  - Motorcycles: 20% increase if rider is under 25 years old.
  - Cargo vans: 15% reduction if driver has more than 5 years of experience.

- **Early Return Charges:**
  - Rental costs are charged at full price for elapsed days and half price for remaining days.
  - Insurance coverage is charged at full price for elapsed days and not charged for remaining days.

## Example

For example, a car valued at $15,000.00 with a safety rating of 3:

```
XXXXXXXXXX
Date: 2024-06-13
Customer Name: John Doe
Rented Vehicle: Mitsubishi Mirage

Reservation start date: 2024-06-03
Reservation end date: 2024-06-13
Reserved rental days: 10 days

Rental cost per day: $15.00
Insurance per day: $1.50

Total rent: $150.00
Total insurance: $15.00
Total: $165.00
XXXXXXXXXX
```

## Usage

1. Clone the repository.
2. Compile and run the Java application.
3. Follow the prompts to input vehicle details and rental information.
4. The application will automatically calculate and display the rental invoice.
