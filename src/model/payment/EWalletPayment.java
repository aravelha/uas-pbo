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
        System.out.printf("Harga awal: Rp%,d%n", totalPrice);
        System.out.printf("Total setelah diskon 5%%: Rp%,.0f untuk %d tiket%n", finalTotal, qty);
        return totalPrice;
    }
}
