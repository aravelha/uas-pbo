package model.payment;

public class CashPayment implements PaymentMethod {
    
    @Override
    public String getName(){
        return "Cash";
    }
    @Override
    public int calculatePayment(int price, int qty){
        int totalPrice = price * qty;
        System.out.printf("Total Pembelian tiket adalah Rp%,d untuk %d tiket%n", totalPrice, qty);
        return totalPrice;
    }
  
}
