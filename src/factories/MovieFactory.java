package factories;

import MovieClasses.*;

import java.util.Scanner;

public class MovieFactory {
    private Scanner scan;
    private Movie movie;

    public MovieFactory() {
        scan = new Scanner(System.in);
         movie = new Movie();
    }

    public Movie createMovie() {
        setMovieName();
        setMovieOscarCount();
        setMovieCoords();
        setMovieGenre();
        return movie;
    }

    public void setMovieName() {
        System.out.println("Введите название фильма");
        movie.setName(scan.nextLine());
    }

    public void setMovieOscarCount() {
        System.out.println("Введите количество оскаров");
        movie.setOscarsCount(scan.nextInt());
    }

    public void setMovieCoords() {
        System.out.println("Введите значение координаты Х(Integer) и У(Float)");
        movie.setCoordinates(new Coordinates(scan.nextInt(), scan.nextFloat()));
    }

    public void setMovieGenre() {
        System.out.println("Введите один из этих энамов, которые хрен знает за что отвечает, потому что я не знаю английский, простите"+"WESTERN" +"\n" +"COMEDY"+"\n"+"MUSICAL"+"SCIENCE_FICTION");
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
        System.out.println("Введите один из этих энамов, которые хрен знает за что отвечает, потому что я не знаю английский, простите"+"G" +"\n" +"PG_13"+"\n"+"R"+"NC_17");
        switch (scan.nextLine()) {
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
        movie.setPerson(new Person(setMoviePersonName(), setMoviePersonWeight(), setMoviePersonPasssID(),setMoviePersonLoc() ));
    }

    public String setMoviePersonName() {
        System.out.println("Введите имя Сценариста");
        return scan.nextLine();
    }

    public int setMoviePersonWeight() {
        System.out.println("Введите его вес (Integer)");
        return scan.nextInt();
    }
    public String setMoviePersonPasssID(){
        System.out.println("Введите eго пасспортный идентификатор");
        return scan.nextLine();
    }
    public Location setMoviePersonLoc(){
        System.out.println("Ввдите координаты х(Long) y(int) z(Float) и название(String) места расположения Сценариста");
        return new Location(scan.nextLong(),scan.nextInt(),scan.nextFloat(),scan.nextLine());
    }
}

