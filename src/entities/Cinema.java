package entities;

import java.util.LinkedList;

public class Cinema {
    private int cinemaNumber;
    private int capacity;
    private LinkedList<Theater> theaters;

    public Cinema(int cinemaNumber, int capacity, LinkedList<Theater> theaters) {
        this.cinemaNumber = cinemaNumber;
        this.capacity = capacity;
        this.theaters = theaters != null ? theaters : new LinkedList<>();
    }

    public int getCinemaNumber() {
        return this.cinemaNumber;
    }

    public void setCinemaNumber(int cinemaNumber) {
        this.cinemaNumber = cinemaNumber;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LinkedList<Theater> getTheaters() {
        return this.theaters;
    }

    public void addTheater(Theater theater) {
        theaters.add(theater);
    }

    public void removeTheater(Theater theater) {
        theaters.remove(theater);
    }
}
