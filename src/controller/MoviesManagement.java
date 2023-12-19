package controller;

import java.util.LinkedList;

import entities.Cinema;
import entities.Movie;
import entities.Showtime;
import entities.Ticket;

public class MoviesManagement {
    private LinkedList<Showtime> showtimes;
    private LinkedList<Movie> movies;
    private LinkedList<Cinema> cinemas;
    private LinkedList<Ticket> tickets;

    public MoviesManagement() {
        this.showtimes = new LinkedList<>();
        this.movies = new LinkedList<>();
        this.cinemas = new LinkedList<>();
        this.tickets = new LinkedList<>();
    }

    

    // Method to add a movie to the list of movies
    public void addMovie(Movie movie) {
        // Ensure that the movies list is initialized before adding a movie
        if (movies == null) {
            movies = new LinkedList<>();
        }
        movies.add(movie);
    }

    // Method to remove a movie from the list of movies
    public void removeMovie(Movie movie) {
        if (movies != null) {
            movies.remove(movie);
        } else {
            System.out.println("There is nothing to remove");
        }
    }

    // Method to get the list of movies
    public LinkedList<Movie> getMovies() {
        return movies;
    }

    public void addCinema(Cinema cinema) {
        // Ensure that the cinemas list is initialized before adding a cinema
        if (cinemas == null) {
            cinemas = new LinkedList<>();
        }
        cinemas.add(cinema);
    }

    public void removeCinema(Cinema cinema) {
        // Ensure that the cinemas list is initialized before adding a cinema
        if (cinemas == null) {
            System.out.println("There is nothing to remove");
        }
        cinemas.remove(cinema);
    }

    // Method to get the list of cinemas
    public LinkedList<Cinema> getCinemas() {
        return cinemas;
    }

    public void addShowtime(Showtime showtime) {
        // Ensure that the showtimes list is initialized before adding a showtime
        if (showtimes == null) {
            showtimes = new LinkedList<>();
        }
        showtimes.add(showtime);
    }

    // Method to remove a showtime from the list of showtimes
    public void removeShowtime(Showtime showtime) {
        if (showtimes != null) {
            showtimes.remove(showtime);
        } else {
            System.out.println("There is nothing to remove");
        }
    }

    public LinkedList<Showtime> getShowtimes() {
        return showtimes;
    }

 
    public void reserveTicket(Showtime showtime) {
        Cinema cinema = showtime.getCinema();
        int availableTickets = calculateAvailableTickets(cinema, showtime);

        if (availableTickets > 0) {
            int ticketNumber = generateTicketNumber();
            double ticketPrice = calculateTicketPrice(showtime);
            Ticket ticket = new Ticket(ticketNumber, ticketPrice, showtime);
            tickets.add(ticket);
            decrementAvailableTickets(cinema, showtime);
            System.out.println("Ticket reserved successfully. Ticket number: " + ticketNumber);
        } else {
            System.out.println("No available tickets for this showtime.");
        }
    }

    // Method to cancel a ticket
    public void cancelTicket(Ticket ticket) {
        if (tickets.contains(ticket)) {
            tickets.remove(ticket);
            incrementAvailableTickets(ticket.getShowtime().getCinema(), ticket.getShowtime());
            System.out.println("Ticket canceled successfully. Ticket number: " + ticket.getTicketNumber());
        } else {
            System.out.println("Ticket not found. Unable to cancel.");
        }
    }

    // Method to display the number of tickets remaining for a given showtime
    public void displayRemainingTickets(Showtime showtime) {
        int availableTickets = calculateAvailableTickets(showtime.getCinema(), showtime);
        System.out.println("Remaining tickets for showtime at Cinema " + showtime.getCinema().getCinemaNumber() +
                ", Theater " + showtime.getTheater().getTheaterNumber() +
                ", Showtime " + showtime.getStartTime() + ": " + availableTickets);
    }

    private int calculateAvailableTickets(Cinema cinema, Showtime showtime) {
        int totalCapacity = cinema.getCapacity();
        int reservedTickets = countReservedTickets(showtime);
        return totalCapacity - reservedTickets;
    }

    // Helper method to count reserved tickets for a showtime
    private int countReservedTickets(Showtime showtime) {
        return (int) tickets.stream()
                .filter(ticket -> ticket.getShowtime().equals(showtime))
                .count();
    }

    // Helper method to decrement available tickets after reservation
    private void decrementAvailableTickets(Cinema cinema, Showtime showtime) {
        showtime.getTheater().getSeats().forEach(seat -> seat.setIsOccupied(true));
    }

    // Helper method to increment available tickets after cancellation
    private void incrementAvailableTickets(Cinema cinema, Showtime showtime) {
        showtime.getTheater().getSeats().forEach(seat -> seat.setIsOccupied(false));
    }

    // Helper method to generate a unique ticket number (you can customize this)
    private int generateTicketNumber() {
        return (int) (Math.random() * 100000);
    }

    // Helper method to calculate ticket price (you can customize this)
    private double calculateTicketPrice(Showtime showtime) {
        return showtime.getMovie().getDuration() * 10.0; // Simple example: price based on movie duration
    }

    public void addTicket(Ticket ticket) {
        if (tickets == null) {
            tickets = new LinkedList<>();
        }
        tickets.add(ticket);
    }

    // Method to remove a ticket from the list of tickets
    public void removeTicket(Ticket ticket) {
        if (tickets != null) {
            tickets.remove(ticket);
        } else {
            System.out.println("There is nothing to remove");
        }
    }

    // Method to get the list of tickets
    public LinkedList<Ticket> getTickets() {
        return tickets;
    }
}
