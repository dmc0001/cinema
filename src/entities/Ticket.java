package entities;

public class Ticket {
    private int ticketNumber;
    private double price;
    private Showtime showtime;

    public Ticket(int ticketNumber, double price, Showtime showtime) {
        this.ticketNumber = ticketNumber;
        this.price = price;
        this.showtime = showtime;
    }

    public int getTicketNumber() {
        return this.ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;

    }

    public Showtime getShowtime() {
        return this.showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}