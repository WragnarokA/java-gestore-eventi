package EventHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Event {
    private String title;
    private LocalDate date;
    private int totalSeats;
    private int reservedSeat;

    //CONSTRUCTOR


    public Event(String title, LocalDate date, int totalSeats) throws Exception{
        if (date.isBefore(LocalDate.now())) {
            throw new Exception("The event date has already passed.");
        }
        if (totalSeats <= 0) {
            throw new Exception("The total number of seats must be positive.");
        }

        this.title = title;
        this.date = date;
        this.totalSeats = totalSeats;
        this.reservedSeat = 0;
    }

    //GETTER - SETTER
    public void setTitolo(String titolo) {
        this.title = titolo;
    }

    public void setDate(LocalDate date) throws Exception {
        if (date.isBefore(LocalDate.now())) {
            throw new Exception("The event date has already passed.");
        }
    }

    public String getTitolo() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getReservedSeat() {
        return reservedSeat;
    }

    //METHODS

    public void reserve(int numSeats) throws Exception {
        if (date.isBefore(LocalDate.now())) {
            throw new Exception("The event has already passed.");
        }
        if (reservedSeat + numSeats > totalSeats) {
            throw new Exception("There are not enough places available.");
        }
        reservedSeat += numSeats;
    }

    public void cancel(int numSeats) throws Exception {
        if (date.isBefore(LocalDate.now())) {
            throw new Exception("The event has already passed.");
        }
        if (reservedSeat - numSeats < 0){
            throw new Exception("There are no reservations to cancel.");
        }
        reservedSeat -= numSeats;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd,MM,yyyy");
        return formatter.format(date) + " - " + title;
    }
}















































