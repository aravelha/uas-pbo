package model;

public class Movie2D extends Movie {
    public Movie2D(String title, int price, int availableTickets) {
        super(title, price, availableTickets);
    }

    @Override
    public String getType() {
        return "2D";
    }
}