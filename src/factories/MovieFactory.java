package factories;

import MovieClasses.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieFactory {
    private Scanner scan;
    private Movie movie;
    private ArrayList<String> par;

    public MovieFactory(ArrayList<String> T) {
        scan = new Scanner(System.in);
        movie = new Movie();
        par=T;
    }

    public Movie createMovie() {
        setMovieName();
        setMovieOscarCount();
        setMovieCoords();
        setMovieGenre();
        setMovieMpaaRating();
        setMoviePerson();
//        scan.close();
        return movie;
    }

    public void setMovieName() {
        if (par!=null){
            movie.setName((par.get(1)));
        }
        else{
            System.out.println("Введите название фильма");
            movie.setName(scan.nextLine());
        }
    }

    public void setMovieOscarCount() {
        System.out.println(par);
        if (par!=null){
            movie.setOscarsCount((Integer.parseInt(par.get(2))));
        }
        else
        {
            System.out.println("Введите количество оскаров");
            movie.setOscarsCount(scan.nextInt());
        }
    }

    public void setMovieCoords() {
        System.out.println("Введите значение координаты Х(Integer) и У(Float)");
        movie.setCoordinates(new Coordinates(scan.nextInt(), scan.nextFloat()));
    }

    public void setMovieGenre() {
        System.out.println("Введите один из этих энамов, которые хрен знает за что отвечает, потому что я не знаю английский, простите"+"\n"+"WESTERN" +"\n" +"COMEDY"+"\n"+"MUSICAL"+"\n"+"SCIENCE_FICTION");
        String buf = scan.next();
        switch (buf) {
            case "WESTERN":
                movie.setMovieGenre(MovieGenre.WESTERN);
            case "COMEDY":
                movie.setMovieGenre(MovieGenre.COMEDY);
            case "MUSICAL":
                movie.setMovieGenre(MovieGenre.MUSICAL);
            case "SCIENCE_FICTION":
                movie.setMovieGenre(MovieGenre.SCIENCE_FICTION);
        }
    }

    public void setMovieMpaaRating() {
        System.out.println("Введите один из этих энамов, которые хрен знает за что отвечает, потому что я не знаю английский, простите"+"\n"+"G" +"\n" +"PG_13"+"\n"+"R"+"\n"+"NC_17");
        String buf = scan.next();
        switch (buf) {
            case "G":
                movie.setMpaaRating(MpaaRating.G);
            case "PG_13":
                movie.setMpaaRating(MpaaRating.PG_13);
            case "R":
                movie.setMpaaRating(MpaaRating.R);
            case "NC_17":
                movie.setMpaaRating(MpaaRating.NC_17);
        }
    }

    public void setMoviePerson() {
        movie.setPerson(new MoviePersonFactory().createMoviePerson());
    }
}


