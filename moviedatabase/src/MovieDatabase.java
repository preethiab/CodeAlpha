import java.util.ArrayList;
import java.util.Scanner;

class Movie {
    private String title;
    private String director;
    private int year;

    public Movie(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Director: " + director + ", Year: " + year;
    }
}

public class MovieDatabase {
    private ArrayList<Movie> movies;

    public MovieDatabase() {
        movies = new ArrayList<>();
    }

    public void addMovie(String title, String director, int year) {
        Movie movie = new Movie(title, director, year);
        movies.add(movie);
        System.out.println("Movie added successfully!");
    }

    public void searchMovie(String query) {
        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(query) || movie.getDirector().equalsIgnoreCase(query)) {
                System.out.println(movie);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Movie not found.");
        }
    }

    public void displayAllMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies in the database.");
        } else {
            System.out.println("List of movies:");
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }

    public static void main(String[] args) {
        MovieDatabase database = new MovieDatabase();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add a new movie");
            System.out.println("2. Search for a movie");
            System.out.println("3. Display all movies");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    database.addMovie(title, director, year);
                    break;
                case 2:
                    System.out.print("Enter movie title or director: ");
                    String query = scanner.nextLine();
                    database.searchMovie(query);
                    break;
                case 3:
                    database.displayAllMovies();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
