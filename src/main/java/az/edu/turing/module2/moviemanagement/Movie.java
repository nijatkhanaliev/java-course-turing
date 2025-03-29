package az.edu.turing.module2.moviemanagement;

public class Movie {
    private String name;
    private double rating;

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        if (rating < 0.0 || rating > 10.0) {
            System.out.println("Rating cannot be more than 10.0 or less than 0.0");
            return;
        }

        this.rating = rating;
    }

    @Override
    public String toString() {
        return "name=" + name + "  " +
                "rating=" + rating;
    }
}
