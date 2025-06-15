package model.payment;

public interface PaymentMethod {
    String getName();
    int calculatePayment(int price, int qty);
}

