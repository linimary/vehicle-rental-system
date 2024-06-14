package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private LocalDate start;
    private LocalDate end;
    private LocalDate returned;

    public Reservation(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public LocalDate getReturned() {
        return returned;
    }

    public void setReturned(LocalDate returned) {
        this.returned = returned;
    }

    public long calculateReservedDays() {
        return ChronoUnit.DAYS.between(start, end);
    }

    public long calculateElapsedDays() {
        return ChronoUnit.DAYS.between(start, returned);
    }

    public long calculateRemainingDays() {
        return calculateReservedDays() - calculateElapsedDays();
    }
}
