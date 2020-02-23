package factories;

import Exceptions.WrongRangeException;
import MovieClasses.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        scan.close();
        return movie;
    }

    public void setMovieName() {
        if (par!=null){
            movie.setName((par.get(1)));
        }
        else{
                System.out.println("Введите название фильма");
                String name= scan.nextLine();
                if (name.isEmpty()){
                    System.out.println("Имя не может быть пустым");
                    setMovieName();
                }
                else {
                    movie.setName(name);
                }
            }
    }

    public void setMovieOscarCount(){
        System.out.println(par);
        if (par!=null){
            movie.setOscarsCount((Integer.parseInt(par.get(2))));
        }
        else
        {
            try{
                System.out.println("Введите количество оскаров(Integer)");
                int i = scan.nextInt();
                if (i>=0) {
                    movie.setOscarsCount(i);
                }
                else {
                    System.out.println("Прости но введеное тобой значение не может быть меньше 0");
                    setMovieOscarCount();
                }
            }
            catch (InputMismatchException e){
                System.out.println("Ты что дурак не знаешь типы данных? Ладно, еще одну попфытку тебе");
                scan.nextLine();
                setMovieOscarCount();
            }
        }
    }

    public void setMovieCoords() {
        System.out.println("Введите значение координаты Х(Integer) и У(Float)");
        try {
            int i = scan.nextInt();
            if (i <= -928) {
                System.out.println("Значение Х должно быть больше -928");
                scan.nextLine();
                setMovieCoords();
            } else {
                Float f = scan.nextFloat();
                if (f >= 982) {
                    System.out.println("Значение поля У должно быть меньше 982");
                    scan.nextLine();
                    setMovieCoords();
                } else {
                    movie.setCoordinates(new Coordinates(i, f));
                    scan.nextLine();
                }
                }
            }catch (InputMismatchException e) {
            System.out.println("Несоответствие типов");
            scan.nextLine();
            setMovieCoords();
        }
    }


    public void setMovieGenre() {
        System.out.println("Введите один из этих энамов, которые хрен знает за что отвечает, потому что я не знаю английский, простите"+"\n"+"WESTERN" +"\n" +"COMEDY"+"\n"+"MUSICAL"+"\n"+"SCIENCE_FICTION");
        String buf = scan.nextLine();
        switch (buf) {
            case "WESTERN":
                movie.setMovieGenre(MovieGenre.WESTERN);
                break;
            case "COMEDY":
                movie.setMovieGenre(MovieGenre.COMEDY);
                break;
            case "MUSICAL":
                movie.setMovieGenre(MovieGenre.MUSICAL);
                break;
            case "SCIENCE_FICTION":
                movie.setMovieGenre(MovieGenre.SCIENCE_FICTION);
                break;
            default:
                System.out.println("Пожалуйсто введите один из предложенных энамов");
                setMovieGenre();
        }
    }

    public void setMovieMpaaRating() {
        System.out.println("Введите один из этих энамов, которые хрен знает за что отвечает, потому что я не знаю английский, простите"+"\n"+"G" +"\n" +"PG_13"+"\n"+"R"+"\n"+"NC_17");
        String buf = scan.next();
        switch (buf) {
            case "G":
                movie.setMpaaRating(MpaaRating.G);
                break;
            case "PG_13":
                movie.setMpaaRating(MpaaRating.PG_13);
                break;
            case "R":
                movie.setMpaaRating(MpaaRating.R);
                break;
            case "NC_17":
                movie.setMpaaRating(MpaaRating.NC_17);
                break;
            default:
                System.out.println("Пожалуйсто введите один из предложенных энамов");
                setMovieMpaaRating();
        }
    }

    public void setMoviePerson() {
        movie.setPerson(new MoviePersonFactory().createMoviePerson());
    }
}


