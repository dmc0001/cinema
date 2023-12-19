package entities;

import java.util.LinkedList;

public class Theater {
    private int theaterNumber;
    private LinkedList<Seat> seats;

    public Theater() {
    }

    public Theater(int theaterNumber, LinkedList<Seat> seats) {
        this.theaterNumber = theaterNumber;
        this.seats = seats;
    }

    public int getTheaterNumber() {
        return this.theaterNumber;
    }

    public void setTheaterNumber(int theaterNumber) {
        this.theaterNumber = theaterNumber;
    }

    public LinkedList<Seat> getSeats() {
        return this.seats;
    }

    void addSeat(Seat seat) {
        seats.add(seat);
    }

    void removeSeat(Seat seat) {
        seats.remove(seat);
    }

}