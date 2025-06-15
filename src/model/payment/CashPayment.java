package model.payment;

public class CashPayment implements PaymentMethod {
    
    @Override
    public String getName(){
        return "Cash";
    }
    @Override
    public int calculatePayment(int price, int qty){
        int totalPrice = price * qty;
        System.out.println("Total Pembelian tiket adalah RP" +totalPrice+ "untuk " +qty+ " tiket");
        return totalPrice;
    }
  
}
