package model;

public abstract class Movie {
    protected String title;
    protected int price;
    protected int availableTickets;

    public Movie(String title, int price, int availableTickets) {
        this.title = title;
        this.price = price;
        this.availableTickets = availableTickets;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void reduceTickets(int qty) {
        this.availableTickets -= qty;
    }

    public abstract String getType();
}
