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
            if (input == null) {
                continue;
            }

            if (input == 1) {
                addNewMovie();
            } else if (input == 2) {
                displayMovies();
            } else if (input == 0) {
                System.out.println("exited");
                break;
            } else if (input == 3) {
                findStatists();
            } else if (input == 4) {
                System.out.println("Enter movie name to search: ");
                Movie movie = searchMovieByName();

                if (movie == null) {
                    System.out.println("Movie not found");
                } else {
                    System.out.println(movie);
                }

            } else if (input == 5) {
                updateMovieRating();

            } else if (input == 6) {
                deleteMovieByName();
            }else if(input == 7){
                sortMoviesByRating();
            }else{
                System.out.println("There is no option with: " + input);
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

            if (isExistsMovie(movieName, newMovie)) {
                System.out.println("Movie already exists");
                i = i - 1;
                continue;
            }

            System.out.println((i + 1) + ".Input new movie rating: ");
            Double movieRating = (Double) isInputValid(5.2);

            if (movieRating == null) {
                return;
            }

            Movie movie = new Movie();
            movie.setName(movieName);
            movie.setRating(movieRating);

            newMovie[i] = movie;

        }
        movies = newMovie;
    }

    public static void findStatists() {
        double max = movies[0].getRating();
        double min = movies[0].getRating();
        double average = 0.0;

        for (int i = 1; i < movies.length; i++) {
            if (movies[i].getRating() > max) {
                max = movies[i].getRating();
            } else if (movies[i].getRating() < min) {
                min = movies[i].getRating();
            }

            average += movies[i].getRating();
        }
        System.out.println("Average rating of movies: " + (average / movies.length));

        for (Movie movie : movies) {
            if (max == min) {
                System.out.println("Min and Max rating are same");
                if (movie.getRating() == max) {
                    System.out.print("Max and Min rating movie: ");
                    System.out.println(movie);
                    break;
                }

            } else {
                if (movie.getRating() == max) {
                    System.out.print("Max rating movie: ");
                    System.out.println(movie);
                }

                if (movie.getRating() == min) {
                    System.out.print("Min rating movie: ");
                    System.out.println(movie);
                }
            }
        }
    }

    public static boolean isExistsMovie(String name, Movie[] newMovie) {
        for (Movie movie : newMovie) {
            if (movie != null) {
                if (movie.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            } else {
                return false;
            }
        }

        return false;
    }

    public static void displayMovies() {
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
    }

    public static Movie searchMovieByName() {
        String movieName = (String) isInputValid("String");

        if (movieName == null) {
            return null;
        }

        for (Movie movie : movies) {
            if (movie.getName().equalsIgnoreCase(movieName)) {
                return movie;
            }
        }

        return null;
    }

    public static void updateMovieRating() {
        System.out.println("Enter movie name to update rating: ");
        Movie movie = searchMovieByName();

        if (movie == null) {
            System.out.println("Movie not found");

            return;
        }

        System.out.println("Enter new rating: ");
        Double newRating = (Double) isInputValid(5.2);

        if (newRating == null) {
            return;
        }

        movie.setRating(newRating);

    }

    public static void deleteMovieByName() {
        System.out.println("Enter move name to delete: ");
        Movie movie = searchMovieByName();

        if (movie == null) {
            System.out.println("Movie not found");
            return;
        }

        Movie[] newMovie = new Movie[movies.length - 1];
        boolean isNameSame = false;

        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getName().equalsIgnoreCase(movie.getName())) {
                isNameSame = true;
                continue;
            }

            if (!isNameSame) {
                newMovie[i] = movies[i];
            } else {
                newMovie[i - 1] = movies[i];
            }

        }

        movies = newMovie;
    }

    public static void sortMoviesByRating() {
        for (int i = 0; i < movies.length; i++) {
            for (int j = 0; j < movies.length - i - 1; j++) {
                if (movies[j].getRating() > movies[j + 1].getRating()) {
                    Movie temp = movies[j];
                    movies[j] = movies[j + 1];
                    movies[j + 1] = temp;
                }
            }
        }
    }

}
