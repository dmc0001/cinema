package entities;

public class Movie {
    private String movieName;
    private Genre genre;
    private double duration;

    public Movie(String movieName, double duration, Genre genre) {
        this.movieName = movieName;
        this.genre = genre;
        this.duration = duration;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getDuration() {
        return this.duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

}
