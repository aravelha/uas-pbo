package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.payment.CashPayment;
import model.payment.EWalletPayment;
import model.payment.PaymentMethod;
import util.OrderSaver;

public class BookingService {
    private List<Movie> movies; // Making the list of the available movies

    public BookingService() {
        movies = new ArrayList<>();
        initMovies(); // Initialize available movies
    }

    // Main method to run the booking service
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== MOVIE BOOKING MENU ===");
            System.out.println("1. Tampilkan Daftar Film");
            System.out.println("2. Pesan Tiket");
            System.out.println("3. Lihat Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showMovies();
                case 2 -> bookTicket();
                case 3 -> viewOrders();
                case 0 -> System.out.println("Terima kasih telah menggunakan layanan kami.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 0);
    }

    // Initialize movies list
    public void initMovies() {
        movies.add(new Movie2D("Avengers", 40000, 30)); // Example 2D movie
        movies.add(new Movie3D("Avatar", 38000, 35)); // Example 3D movie
        movies.add(new MovieIMAX("Interstellar", 40000, 20)); // Example IMAX movie
    }

    // Show all available movies
    public void showMovies() {
        System.out.println("\n============================================================");
        System.out.println("                         DAFTAR FILM TERSEDIA");
        System.out.println("===============================================================");
        System.out.printf("%-4s %-20s %-10s %-10s %-10s%n", "No", "Judul", "Harga", "Tipe", "Tiket");
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            System.out.printf("%-4d %-20s Rp%,8d %-10s %5d%n",
                    (i + 1),
                    movie.getTitle(),
                    movie.getPrice(),
                    movie.getType(),
                    movie.getAvailableTickets());
        }

        System.out.println("-------------------------------------------------------------");
    }

    // Logic to book a ticket
    public void bookTicket() {
        Scanner scanner = new Scanner(System.in);

        // Display available movies
        showMovies();
        System.out.print("Pilih film (1 - " + movies.size() + "): ");
        int movieChoice = scanner.nextInt();

        // Validate input
        if (movieChoice < 1 || movieChoice > movies.size()) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        Movie selectedMovie = movies.get(movieChoice - 1);

        // Ask for quantity
        System.out.print("Jumlah tiket: ");
        int quantity = scanner.nextInt();

        // Check ticket availability
        if (quantity > selectedMovie.getAvailableTickets()) {
            System.out.println("Maaf, tiket yang tersedia hanya " + selectedMovie.getAvailableTickets());
            return;
        }

        // Ask for payment method
        System.out.println("Pilih metode pembayaran:");
        System.out.println("1. Cash");
        System.out.println("2. E-Wallet");
        System.out.print("Masukkan pilihan: ");
        int paymentChoice = scanner.nextInt();

        PaymentMethod paymentMethod;
        if (paymentChoice == 2) {
            paymentMethod = new EWalletPayment();
        } else {
            paymentMethod = new CashPayment(); // Default is cash
        }

        // Reduce ticket stock
        selectedMovie.reduceTickets(quantity);

        // Create and process order
        Order order = new Order(selectedMovie, quantity, paymentMethod);
        saveOrderToFile(order);

        // Show final result
        System.out.println("\n===================================");
        System.out.println("        PESANAN BERHASIL");
        System.out.println("===================================");
        System.out.println("Judul Film     : " + order.getMovie().getTitle());
        System.out.println("Jumlah Tiket   : " + order.getQuantity());
        System.out.println("Metode Pembayaran   : " + order.getPaymentMethod());
        System.out.printf("Total Bayar    : Rp%,d%n", order.getTotalPrice());
        System.out.println("===================================\n");
    }

    public void viewOrders() {
        System.out.println("Current Orders:");
        OrderSaver.readOrders(); // Note the static call
    }

    public void saveOrderToFile(Order order) {
        OrderSaver.saveOrder(order); // Static method call
    }
}
