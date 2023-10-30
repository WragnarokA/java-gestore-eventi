package EventHandler;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event {
    private LocalTime time;
    private BigDecimal price;

    //CONSTRUCTOR
    public Concert(String title, LocalDate date, int totalSeats, LocalTime time, BigDecimal price) throws Exception {
        super(title, date, totalSeats);
        this.time = time;
        this.price = price;
    }

    //GETTER & SETTER
    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //METHODS
    public String getDateFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter.format(getDate());
    }

    public String getTimeFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return formatter.format(time);
    }

    public String getPriceFormatter(){
        return  String.format("%.2f€", price);
    }

    @Override
    public String toString() {
        return getDateFormatter() + " - " + getTitolo() + " - " + getPriceFormatter();
    }
}
