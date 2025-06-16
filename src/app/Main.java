package app; // or remove this line if you're not using a package

import model.BookingService;

public class Main {
    public static void main(String[] args) {
        BookingService service = new BookingService();
        service.run();
    }
}
