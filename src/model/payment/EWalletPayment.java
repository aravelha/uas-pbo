package model.payment;

public class EWalletPayment implements PaymentMethod {
    private static final double discount = 0.05;
    @Override
    public String getName() {
        return "E-Wallet";
    }

    @Override
    public int calculatePayment(int price, int qty) {
        int totalPrice = price * qty;
        double finalTotal = totalPrice * (1- discount);
        return (int) finalTotal;
    }
}
