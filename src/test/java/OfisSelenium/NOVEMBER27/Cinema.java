package OfisSelenium.NOVEMBER27;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Movie movie1 = new Action();
        movie1.setIdNumber(1);
        movie1.setRating("PG-13");
        movie1.setTitle("Ford v Ferrari");

        Movie movie2 = new Movie();
        movie2.setIdNumber(2);
        movie2.setRating("PG");
        movie2.setTitle("Frozen 2");


//        System.out.println(movie1.equals(movie2));
//        System.out.println(movie1);
//        System.out.println(movie2);

        Movie[] movies = new Movie[2];
        movies[0] = movie1;
        movies[1] = movie2;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a movie ID: ");
        int movieId = scanner.nextInt();
        if(movieId <= movies.length){
            System.out.print("How many days it was late?: ");
            int days = scanner.nextInt();
            System.out.print("Late fee is: "+movies[movieId-1].calcLateFees(days)+"$");
        }else {
            System.out.print("\nInvalid movie id!");
        }
    }
}
