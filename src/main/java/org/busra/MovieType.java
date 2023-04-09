package src.main.java.org.busra;

public enum MovieType {
    THRILLER, ROMANCE, ACTION, ADVENTURE, COMEDY, DRAMA,
    FANTASY, HORROR, MUSICALS, SCIENCE_FICTION, SPORTS, DEFAULT;

    public static MovieType ignoreCase(String movieType) {
        for (MovieType type : MovieType.values()) {
            if (movieType.equalsIgnoreCase(type.toString())) {
                return type;
            }
        }
        return DEFAULT;
    }
}
