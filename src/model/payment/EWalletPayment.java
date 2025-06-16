package model.payment;

public class EWalletPayment implements PaymentMethod {
    @Override
    public String getName() {
        return "E-Wallet";
    }

    @Override
    public int calculatePayment(int price, int qty) {
        int totalPrice = price * qty;
        double finalTotal = totalPrice * 0.95;
        return (int) finalTotal;
    }
}
