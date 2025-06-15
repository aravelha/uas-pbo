package model;

public class Movie3D extends Movie {
    public Movie3D(String title, int price, int availableTickets) {
        super(title, price, availableTickets);
    }

    @Override
    public String getType() {
        return "3D";
    }
}
