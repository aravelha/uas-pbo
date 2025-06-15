package app.util;

import app.model.Order;

import java.io.BufferedWriter;
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
}