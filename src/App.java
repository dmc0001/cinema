import java.util.Date;
import java.util.LinkedList;

import controller.MoviesManagement;
import entities.*;

public class App {
    public static void main(String[] args) throws Exception {

        MoviesManagement moviesManagement = new MoviesManagement();

        // Add a movie
        Movie movie = new Movie("Inception", 2.5, Genre.SCIFI);
        moviesManagement.addMovie(movie);

        // Add theaters with seats
        LinkedList<Theater> theatersList1 = new LinkedList<>();
        theatersList1.add(new Theater(1, getSeats()));
        theatersList1.add(new Theater(2, getSeats()));

        LinkedList<Theater> theatersList2 = new LinkedList<>();
        theatersList2.add(new Theater(3, getSeats()));
        theatersList2.add(new Theater(4, getSeats()));

        // Add cinemas
        Cinema cinema1 = new Cinema(1, 100, theatersList1);
        Cinema cinema2 = new Cinema(2, 150, theatersList2);
        moviesManagement.addCinema(cinema1);
        moviesManagement.addCinema(cinema2);

        // Add showtimes
        Showtime showtime1 = new Showtime(new Date(), new Date(), cinema1, movie, theatersList1.getFirst());
        Showtime showtime2 = new Showtime(new Date(), new Date(), cinema2, movie, theatersList2.getFirst());
        moviesManagement.addShowtime(showtime1);
        moviesManagement.addShowtime(showtime2);

        // Display movie details
        LinkedList<Movie> movieList = moviesManagement.getMovies();
        System.out.println("Movies:");
        for (Movie m : movieList) {
            System.out.println("Movie Name: " + m.getMovieName());
            System.out.println("Genre: " + m.getGenre().getValue());
            System.out.println("Duration: " + m.getDuration() + " hours");
            System.out.println("-----");
        }

        // Display cinema details with theaters and seats
        LinkedList<Cinema> cinemaList = moviesManagement.getCinemas();
        System.out.println("Cinemas:");
        for (Cinema cinema : cinemaList) {
            System.out.println("Cinema Number: " + cinema.getCinemaNumber());
            System.out.println("Capacity: " + cinema.getCapacity());

            // Display theater details for each cinema
            System.out.println("Theaters:");
            LinkedList<Theater> theaterList = cinema.getTheaters();
            for (Theater theater : theaterList) {
                System.out.println("Theater Number: " + theater.getTheaterNumber());
                System.out.println("Seats:");
                for (Seat seat : theater.getSeats()) {
                    System.out.println("Seat Number: " + seat.getSeatNumber() + ", Occupied: " + seat.getIsOccupied());
                }
                System.out.println("-----");
            }
            System.out.println("-----");
        }

        // Display showtime details
        LinkedList<Showtime> showtimeList = moviesManagement.getShowtimes();
        System.out.println("Showtimes:");
        for (Showtime showtime : showtimeList) {
            System.out.println("Movie: " + showtime.getMovie().getMovieName());
            System.out.println("Cinema Number: " + showtime.getCinema().getCinemaNumber());
            System.out.println("Start Time: " + showtime.getStartTime());
            System.out.println("Stop Time: " + showtime.getStopTime());
            System.out.println("-----");

            // Reserve a ticket for each showtime
            moviesManagement.reserveTicket(showtime);
        }

        // Display remaining tickets for each showtime
        for (Showtime showtime : showtimeList) {
            moviesManagement.displayRemainingTickets(showtime);
        }

        // Cancel a ticket for the first showtime
        LinkedList<Ticket> ticketsList = moviesManagement.getTickets();
        if (!ticketsList.isEmpty()) {
            Ticket firstTicket = ticketsList.getFirst();
            moviesManagement.cancelTicket(firstTicket);
        }
    }

    // Helper method to create a list of seats for a theater
    private static LinkedList<Seat> getSeats() {
        LinkedList<Seat> seats = new LinkedList<>();
        seats.add(new Seat(1, false));
        seats.add(new Seat(2, false));
        seats.add(new Seat(3, true));
        seats.add(new Seat(4, false));
        // Add more seats as needed
        return seats;
    }
}
