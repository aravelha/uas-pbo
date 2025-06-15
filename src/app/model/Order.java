package app.model;

import app.model.payment.PaymentMethod;

public class Order {
    private Movie movie;
    private int quantity;
    private PaymentMethod paymentMethod;

    public Order(Movie movie, int quantity, PaymentMethod paymentMethod) {
        this.movie = movie;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPaymentMethod() {
        return paymentMethod.getName();
    }

    public int getTotalPrice() {
        return paymentMethod.calculatePayment(movie.getPrice(), quantity);
    }

    @Override
    public String toString() {
        return "Movie: " + movie.getTitle()
             + ", Quantity: " + quantity
             + ", Payment: " + getPaymentMethod()
             + ", Total: Rp" + getTotalPrice();
    }
}