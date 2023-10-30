package EventHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert the name of the new event: ");
        String title = scanner.nextLine();
        System.out.print("Insert tha date of the event: (format: dd/mm/yyyy): ");
        String dateString = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Insert the total seat of the event: ");
        int totalSeats = Integer.parseInt(scanner.nextLine());

        try {
            Event event = new Event(title, date, totalSeats);
            System.out.println("Event created successfully");

            while (true){
                System.out.print("How many seats do you want to reserve for this event? ");
                int numSeats = Integer.parseInt(scanner.nextLine());
                try {
                    event.reserve(numSeats);
                    System.out.println(numSeats + " Seats booked successfully ");
                    break;
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            System.out.println();

            while (true){
                System.out.print("How many seats do you want cancel for this event? ");
                int numSeats = Integer.parseInt(scanner.nextLine());
                try {
                    event.cancel(numSeats);
                    System.out.println(numSeats + "Seats cancelled successfully");
                    break;
                }catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            System.out.println();
            System.out.println("Number of seats booked: " + event.getReservedSeat());
            System.out.println("Number of seats available: " + (event.getTotalSeats() - event.getReservedSeat()));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        scanner.close();
    }
}














