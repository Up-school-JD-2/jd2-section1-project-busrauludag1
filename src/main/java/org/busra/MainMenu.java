package src.main.java.org.busra;

import java.time.LocalDate;
import java.util.*;

public class MainMenu {
    static UserManager userManager = new UserManager();
    static MovieManager movieManager = new MovieManager();
    public static void run(){
        int choice = 0;

        createUsers();
        createMovies();

        System.out.println("-----   Welcome to the MOVIE LIBRARY   -----");
        System.out.println("Please enter your user name and password to login: ");

        while (!logIn()){
            logIn();
        }
        printMenu();
        boolean logIn = true;

        do {
            System.out.println("Make your choice? ");
            try {
                Scanner kb = new Scanner(System.in);
                choice = kb.nextInt();

                switch (choice){
                    case 1 ->
                        listUser();
                    case 2 -> {
                        addUser();
                    }
                    case 3 -> {
                        deleteUser();
                    }
                    case 4 -> {
                        searchUserByName();
                    }
                    case 5 -> {
                        listMovies();
                    }
                    case 6 -> {
                        addMovie();
                    }
                    case 7 -> {
                        deleteMovieById();
                    }
                    case 8 -> {
                        searchMovieByName();
                    }
                    case 9 -> {
                        searchMoviesByDirector();
                    }
                    case 10 -> {
                        searchMoviesByType();
                    }
                    case 0 -> {
                        if (logIn)
                            logOut();
                    }
                    default -> printMenu();
                }
            } catch (InputMismatchException inputMismatchException){
                System.out.println("Please enter a number to choice !");
            }
        } while (choice != 0);
    }

    public static void createMovies(){
        movieManager.addMovie(new Movie("Dunkirk", "Christopher Nolan", LocalDate.of(2017, 07, 19), MovieType.DRAMA))
                    .addMovie(new Movie("Inception", "Christopher Nolan", LocalDate.of(2010, 07, 30), MovieType.SCIENCE_FICTION))
                    .addMovie(new Movie("Titanic", "James Cameron", LocalDate.of(1997, 12, 19), MovieType.ROMANCE))
                    .addMovie(new Movie("Schindler's List", "Steven Spielberg", LocalDate.of(1994, 03, 04), MovieType.DRAMA))
                    .addMovie(new Movie("Back to the Future", "Robert Zemeckis", LocalDate.of(1985, 07, 03), MovieType.ADVENTURE))
                    .addMovie(new Movie("Interstellar", "Christopher Nolan", LocalDate.of(2014, 10, 26), MovieType.SCIENCE_FICTION,
                        "It follows a group of astronauts who travel through a wormhole near Saturn in search of a new home for mankind.",
                        new ArrayList<>(Arrays.asList("Anne Hathaway", "Matthew McConaughey", "Jessica Chastain", "Bill Irwin", "Ellen Burstyn", "Michael Caine"))));

    }

    public static void createUsers(){
        userManager.addUser("Busra", "123456", "busra@gmail.com")
                   .addUser("Zakire", "654321", "zakirecinar@gmail.com")
                   .addUser("Humeyra", "asdgacz", "humeyra@outlook.com.tr")
                   .addUser("Ceren", "cerenimo", "ceren@gmail")
                   .addUser("naz", "kar" ,"nazkar")
                   .addUser("zey", "nep", "zeyno")
                   .addUser("b", "u", "b"); // test user
    }

    public static boolean logIn(){
        Scanner kb = new Scanner(System.in);
        String userName = kb.nextLine();
        String password = kb.nextLine();
        User userByName= userManager.searchUserByName(userName);
        User userByPasswd = userManager.searchUserByPassword(password);
        if (userByName == null || userByPasswd == null ){
            System.out.println("User not found. Please try again.");
            return false;
        } else
            System.out.println("Your login is successful. Make your choice from menu below !");
            return true;
    }

    public static void logOut(){
        System.out.println("Log out is successful. GOOD BYE...");
    }
    public static void printMenu(){
        System.out.println("####    MENU    ####");
        System.out.println("1: List users ");
        System.out.println("2: Add user ");
        System.out.println("3: Delete user ");
        System.out.println("4: Search user ");
        System.out.println("5: List movies ");
        System.out.println("6: Add movie ");
        System.out.println("7: Delete movie ");
        System.out.println("8: Search movie ");
        System.out.println("9: Search director ");
        System.out.println("10: Search type ");
        System.out.println("0: Exit\n");
    }

    private static void listUser() {
        System.out.println("-------------------------");
        userManager.listUsers();
        System.out.println("-------------------------");
    }

    private static void addUser() {
        Scanner kb = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Enter user name: ");
        String userName = kb.nextLine();
        System.out.println("Enter password: ");
        String password = kb.nextLine();
        System.out.println("Enter e-mail: ");
        String eMail = kb.nextLine();
        userManager.addUser(userName, password, eMail);
        userManager.listUsers();
        System.out.println("-------------------------");
    }

    private static void deleteUser() {
        Scanner kb = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Enter user name: ");
        String userName = kb.nextLine();
        User userByName = userManager.searchUserByName(userName);
        if (userByName == null){
            System.out.println("User not found.");
        }
        System.out.println("Enter user password: ");
        String password = kb.nextLine();
        User userByPasswd = userManager.searchUserByPassword(password);
        if (userByPasswd == null){
            System.out.println("User password not found.");
        }
        System.out.println("Enter user e-mail: ");
        String eMail = kb.nextLine();
        User userByEmail = userManager.searchUserByEmail(eMail);
        if (userByEmail == null){
            System.out.println("User e-mail not found.");
        }
        userManager.deleteUser(userName, password, eMail);
        userManager.listUsers();
        System.out.println("-------------------------");
    }

    private static void searchUserByName(){
        Scanner kb = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Enter user name you want to search: ");
        String userName = kb.nextLine();
        userManager.printUserByName(userName);
    }

    private static void listMovies(){
        System.out.println("-------------------------");
        movieManager.listMovies();
        System.out.println("-------------------------");
    }

    private static void addMovie(){
        Scanner kb = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Enter movie name: ");
        String movieName = kb.nextLine();
        System.out.println("Enter director: ");
        String director = kb.nextLine();
        System.out.println("Enter movie type: ");
        String movieTypeString = kb.nextLine();
        MovieType movieType = MovieType.ignoreCase(movieTypeString);
        System.out.println("Enter published year: ");
        LocalDate date = LocalDate.of(kb.nextInt(), 01, 01);
        movieManager.addMovie(movieName, director, date, movieType);
        movieManager.listMovies();
        System.out.println("-------------------------");
    }

    private static void deleteMovieById(){
        Scanner kb = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Enter movie ID: ");
        String movieId = kb.nextLine();
        Movie movieById = movieManager.searchMovieById(movieId);
        if (movieById == null){
            System.out.println("Movie ID not found.");
        }
        movieManager.deleteMovieById(movieId);
        movieManager.listMovies();
        System.out.println("-------------------------");
    }

    private static void searchMovieByName(){
        Scanner kb = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Enter movie name you want to search: ");
        String movieName = kb.nextLine();
        movieManager.searchMovieByName(movieName);
    }

    private static void searchMoviesByDirector(){
        Scanner kb = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Enter director you want to search: ");
        String director = kb.nextLine();
        movieManager.searchMoviesByDirector(director);
    }

    private static void searchMoviesByType(){
        Scanner kb = new Scanner(System.in);
        System.out.println("-------------------------");
        System.out.println("Enter movie type you want to search: ");
        String movieTypeString = kb.nextLine();
        MovieType movieType = MovieType.ignoreCase(movieTypeString);
        movieManager.searchMoviesByType(movieType);
    }


}
