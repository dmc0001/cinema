package entities;

import java.util.Date;

public class Showtime {
    private Date startTime;
    private Date stopTime;
    private Cinema cinema;
    private Movie movie;
    private Theater theater; // Add theater property

    public Showtime(Date startTime, Date stopTime, Cinema cinema, Movie movie, Theater theater) {
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.cinema = cinema;
        this.movie = movie;
        this.theater = theater;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theater getTheater() {
        return theater;
    }
}
