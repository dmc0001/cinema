package entities;

public class Seat {
    private int seatNumber;
    private boolean isOccupied;

    public Seat(int seatNumber, boolean isOccupied) {
        this.seatNumber = seatNumber;
        this.isOccupied = isOccupied;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isIsOccupied() {
        return this.isOccupied;
    }

    public boolean getIsOccupied() {
        return this.isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Seat seatNumber(int seatNumber) {
        setSeatNumber(seatNumber);
        return this;
    }

    public Seat isOccupied(boolean isOccupied) {
        setIsOccupied(isOccupied);
        return this;
    }

}