package app; 

import model.BookingService;

public class Main {
    public static void main(String[] args) {
        BookingService service = new BookingService();
        service.run();
    }
}
