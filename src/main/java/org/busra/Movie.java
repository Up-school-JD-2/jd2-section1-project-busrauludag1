package src.main.java.org.busra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Movie {
    private final String id;
    private String name;
    private String director;
    private LocalDate publishedDate;
    private MovieType type;
    private String description;
    private ArrayList<String> players = new ArrayList<>();

    public Movie(String name, String director, LocalDate publishedDate, MovieType type) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.director = director;
        this.publishedDate = publishedDate;
        this.type = type;
    }

    public Movie(String name, String director, LocalDate publishedDate, MovieType type, String description, ArrayList<String> players) {
        this(name, director, publishedDate, type);
        this.description = description;
        this.players = players;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public MovieType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getPlayers() {
        return players;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setType(MovieType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPlayers(ArrayList<String> players) {
        this.players = players;
    }

    @Override
    public String toString(){
        return "Movie {" +
                "ID: " + id + ", " +
                "Name: " + name + ", " +
                "Director: " + director + ", " +
                "Published Date: " + publishedDate + ", " +
                "Type: " + type + ", " +
                "Description: " + description + ", " +
                "Players: " + players.toString() +
                "}" + "\n";
    }

}
