package util;

import model.Order;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OrderSaver {

    private static final String FILE_NAME = "orders.txt";

    public static void saveOrder(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(order.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Gagal menyimpan order: " + e.getMessage());
        }
    }

    public static void readOrders() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            System.out.println("\n===================================");
            System.out.println("         DAFTAR PESANAN");
            System.out.println("===================================");
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int count = 1;
                while ((line = reader.readLine()) != null) {
                    System.out.println(count++ + ". " + line);
                }
            } catch (IOException e) {
                System.out.println("Gagal membaca order: " + e.getMessage());
            }
        } else {
            System.out.println("Belum ada pesanan yang tersimpan.");
        }
        System.out.println("===================================\n");
    }

}