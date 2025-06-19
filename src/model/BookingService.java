package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.payment.CashPayment;
import model.payment.EWalletPayment;
import model.payment.PaymentMethod;
import util.OrderSaver;

public class BookingService {
    private List<Movie> movies;

    public BookingService() {
        movies = new ArrayList<>();
        initMovies();
    }

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

public void initMovies() {
    Movie[] movieArray = {
        new Movie2D("Avengers", 40000, 30),
        new Movie3D("Avatar", 38000, 35),
        new MovieIMAX("Interstellar", 40000, 20)
    };

    for (Movie movie : movieArray) {
        movies.add(movie);
    }
}

    public void showMovies() {
        System.out.println("\n===============================================================");
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

    public void bookTicket() {
        Scanner scanner = new Scanner(System.in);

        showMovies();
        System.out.print("Pilih film (1 - " + movies.size() + "): ");
        int movieChoice = scanner.nextInt();

        if (movieChoice < 1 || movieChoice > movies.size()) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        Movie selectedMovie = movies.get(movieChoice - 1);

        System.out.print("Jumlah tiket: ");
        int quantity = scanner.nextInt();

        if (quantity > selectedMovie.getAvailableTickets()) {
            System.out.println("Maaf, tiket yang tersedia hanya " + selectedMovie.getAvailableTickets());
            return;
        }

        System.out.println("Pilih metode pembayaran:");
        System.out.println("1. Cash");
        System.out.println("2. E-Wallet");
        System.out.print("Masukkan pilihan: ");
        int paymentChoice = scanner.nextInt();

        PaymentMethod paymentMethod = (paymentChoice == 2) ? new EWalletPayment() : new CashPayment();

        selectedMovie.reduceTickets(quantity);

        Order order = new Order(selectedMovie, quantity, paymentMethod);
        saveOrderToFile(order);

        int hargaAwal = selectedMovie.getPrice() * quantity;
        int totalBayar = order.getTotalPrice();

        System.out.println("\n===================================");
        System.out.println("        PESANAN BERHASIL");
        System.out.println("===================================");
        System.out.println("Judul Film     : " + selectedMovie.getTitle());
        System.out.println("Jumlah Tiket   : " + quantity);
        System.out.println("Metode Pembayaran   : " + order.getPaymentMethod());

        if (paymentMethod instanceof EWalletPayment) {
            System.out.printf("Harga Awal     : Rp%,d%n", hargaAwal);
            System.out.printf("Total setelah diskon 5%%: Rp%,d%n", totalBayar);
        }

        System.out.printf("Total Bayar    : Rp%,d%n", totalBayar);
        System.out.println("===================================\n");
    }

    public void viewOrders() {
        System.out.println("Current Orders:");
        OrderSaver.readOrders();
    }

    public void saveOrderToFile(Order order) {
        OrderSaver.saveOrder(order);
    }
}
