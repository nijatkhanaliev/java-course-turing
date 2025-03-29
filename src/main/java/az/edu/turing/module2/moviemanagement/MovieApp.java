package az.edu.turing.module2.moviemanagement;

import java.util.Scanner;

public class MovieApp {
    private static Movie[] movies = new Movie[0];
    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            showMenu();
            System.out.println("Your choice: ");
            Integer input = (Integer) isInputValid(2);

            if (input == 1) {
                addNewMovie();
            } else if (input == 2) {
                boolean movieFound = true;
                for (Movie movie : movies) {
                    if (movie != null) {
                        System.out.println(movie);
                    } else {
                        movieFound = false;
                        break;
                    }
                }

                if (!movieFound) System.out.println("Movie not found");

            } else if (input == 0) {
                System.out.println("exited");
                break;
            }

        }


    }

    public static void showMenu() {
        System.out.println("press 0 to exit");
        System.out.println("press 1 to add movies");
        System.out.println("press 2 to display movies and ratings");
        System.out.println("press 3 to find statistics");
        System.out.println("press 4 to search movie");
        System.out.println("press 5 to update movie rating");
        System.out.println("press 6 to delete movie");
        System.out.println("press 7 to sort movies");
    }

    public static Object isInputValid(Object requiredType) {
        if (requiredType instanceof Integer) {
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Required type is Integer");
                sc.nextLine();

                return null;
            }

            Integer value = sc.nextInt();
            sc.nextLine();
            return value;

        } else if (requiredType instanceof String) {
            if (!sc.hasNext()) {
                System.out.println("Invalid input. Required type is String");
                sc.nextLine();

                return null;
            }
            return sc.nextLine();

        } else if (requiredType instanceof Double) {
            if (!sc.hasNextDouble()) {
                System.out.println("Invalid input. Required type is Double");
                sc.nextLine();

                return null;
            }
            Double value = sc.nextDouble();
            sc.nextLine();
            return value;
        }

        System.out.println("Invalid input.");
        sc.nextLine();
        return null;
    }

    public static void addNewMovie() {
        System.out.println("How many movies do you want do add");

        Integer count = (Integer) isInputValid(2);

        if (count == null) {
            return;
        }

        Movie[] newMovie = new Movie[movies.length + count];

        for (int i = 0; i < movies.length; i++) {
            newMovie[i] = movies[i];
        }

        for (int i = movies.length; i < newMovie.length; i++) {
            System.out.println((i + 1) + ".Input movie name: ");
            String movieName = (String) isInputValid("string");

            if (movieName == null) {
                return;
            }

            System.out.println((i + 1) + ".Input new movie rating: ");
            Double movieRating = (Double) isInputValid(5.2);

            if (movieRating == null) {
                return;
            }

            newMovie[i] = new Movie(movieName, movieRating);

        }
        movies = newMovie;
    }

}
