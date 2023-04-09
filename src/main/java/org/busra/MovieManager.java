package src.main.java.org.busra;

import java.time.LocalDate;
import java.util.ArrayList;

public class MovieManager{
    private final ArrayList<Movie> movies;
    public MovieManager(){
        movies = new ArrayList<>();
    }

    public MovieManager addMovie(Movie movie){
        movies.add(movie);
        return this;
    }

    public MovieManager addMovie(String name, String director, LocalDate publishedDate, MovieType type){
        return addMovie(new Movie(name, director, publishedDate, type));
    }

    public MovieManager deleteMovie(Movie movie){
        movies.remove(movie);
        return this;
    }

    public void deleteMovieById(String id){
        movies.removeIf(movie -> movie.getId().equals(id));
    }

    public Movie searchMovieById(String id){
        Movie searchedMovie = null;
        for (Movie movie : movies)
            if (movie.getId().equals(id)){
                searchedMovie = movie;
                break;
            }
        return searchedMovie;
    }

    public void searchMovieByName(String movieName){
        for (Movie movie : movies)
            if (movie.getName().equalsIgnoreCase(movieName)){
                System.out.println(movie);
            }
    }

    public void searchMoviesByDirector(String director){
        for (Movie movie : movies) {
            if (movie.getDirector().equalsIgnoreCase(director)) {
                System.out.println(movie);
            }
        }
    }


    public Movie searchMovieByPublishedDate(LocalDate date){
        Movie searchedMovie = null;
        for (Movie movie : movies){
            if (movie.getPublishedDate().equals(date)){
                searchedMovie = movie;
                break;
            }
        }
        return searchedMovie;
    }

    public void searchMoviesByType(MovieType type){
        for (Movie movie: movies){
            if (movie.getType().equals(type)){
                System.out.println(movie);
            }
        }
    }

    public void listMovies(){
        for (Movie movie : movies){
            System.out.println(movie.toString());
        }
    }

}
