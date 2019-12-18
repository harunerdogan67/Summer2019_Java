package OfisSelenium.NOVEMBER27;

public class Movie extends Object {
    //rating (e.g., Rated G, PG-13, R), ID Number, and movie title with
    private String rating;
    private int idNumber;
    private String title;

    //accessor and mutator methods. means getter and setter methods


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //based on our criteria, check if 2 object are same
    @Override
    public boolean equals(Object object) {
        Movie movie = (Movie) object;
        return this.idNumber == movie.getIdNumber();
    }

    //to describe object
    @Override
    public String toString() {
        return "Movie{" +
                "rating='" + rating + '\'' +
                ", idNumber=" + idNumber +
                ", title='" + title + '\'' +
                '}';
    }

    //    create an overridden method named calcLateFees
//    that takes as input the number of days a movie
//    is late and returns the late fee for that movie.
//    The default late fee is $2/day.
    public double calcLateFees(int days) {
        return days * 2;
    }


    public Movie getMovieById(Movie[] movies, int movieId) {
        for (Movie m : movies) {
            if (m.idNumber == movieId) {
                return m;
            }
        }
        return null;
    }
}
