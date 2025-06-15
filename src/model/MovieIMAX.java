package model;

public class MovieIMAX extends Movie {
    public MovieIMAX(String title, int price, int availableTickets) {
        super(title, price, availableTickets);
    }

    @Override
    public String getType() {
        return "IMAX";
    }
}