package EventHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Event {
    private String title;
    private LocalDate date;
    private int totalPlace;
    private int reservedPlace;

    //CONSTRUCTOR


    public Event(String title, LocalDate date, int totalPlace) throws Exception{
        if (date.isBefore(LocalDate.now())) {
            throw new Exception("The event date has already passed.");
        }
        if (totalPlace <= 0) {
            throw new Exception("The total number of seats must be positive.");
        }

        this.title = title;
        this.date = date;
        this.totalPlace = totalPlace;
        this.reservedPlace = 0;
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

    public int getTotalPlace() {
        return totalPlace;
    }

    public int getReservedPlace() {
        return reservedPlace;
    }

    //METHODS

    public void reserve(int numPlaces) throws Exception {
        if (date.isBefore(LocalDate.now())) {
            throw new Exception("The event has already passed.");
        }
        if (reservedPlace + numPlaces > totalPlace) {
            throw new Exception("There are not enough places available.");
        }
        reservedPlace += numPlaces;
    }

    public void cancel(int numPlaces) throws Exception {
        if (date.isBefore(LocalDate.now())) {
            throw new Exception("The event has already passed.");
        }
        if (reservedPlace - numPlaces < 0){
            throw new Exception("There are no reservations to cancel.");
        }
        reservedPlace -= numPlaces;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd,MM,yyyy");
        return formatter.format(date) + " - " + title;
    }
}















































