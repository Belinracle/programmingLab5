package factories;

import Exceptions.WrongRangeException;
import MovieClasses.*;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Scanner;

public class MovieFactory {
    private BufferedReader scan;
    private Movie movie;
    private ArrayList<String> par;
    public MovieFactory() throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        scan = new BufferedReader(inputStreamReader);
        movie = new Movie();
    }

    public Movie createMovie(ArrayList<String> T) throws IOException {
        par=T;
        movie.setID(IDFactory.createID());
        setMovieName();
//        setMovieOscarCount();
//        setMovieCoords();
//        setMovieGenre();
//        setMovieMpaaRating();
        setMoviePerson();
        System.out.println("Спасибо, фильм создан");
        return movie;
    }
    public Movie updateID(Long ID) throws IOException {
        movie.setID(ID);
        setMovieName();
//        setMovieOscarCount();
//        setMovieCoords();
//        setMovieGenre();
//        setMovieMpaaRating();
        setMoviePerson();
        System.out.println("Спасибо, фильм создан");
        return movie;
    }

    public void setMovieName() throws IOException {
        if (par!=null){
            movie.setName((par.get(1)));
        }
        else{
            System.out.println("Введите название фильма");
            String name=scan.readLine();
            System.out.println(name);
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
        if (par!=null){
            movie.setOscarsCount((Integer.parseInt(par.get(2))));
        }
        else
        {
            try{
                System.out.println("Введите количество оскаров(Integer)");
                String i;
                do{i= scan.readLine();}
                while(i.isEmpty());
                int inti=Integer.parseInt(i);
                if (inti>=0) {
                    movie.setOscarsCount(inti);
                }
                else {
                    System.out.println("Прости но введеное тобой значение не может быть меньше 0");
                    setMovieOscarCount();
                }
            }
            catch (NumberFormatException | IOException e){
                System.out.println("Ты что дурак не знаешь типы данных? Ладно, еще одну попфытку тебе");
                setMovieOscarCount();
            }
        }
    }

    public void setMovieCoords() {
        System.out.println("Введите значение координаты Х(Integer) и У(Float)");
        try {
            String i;
            do{i= scan.readLine();}
            while(i.isEmpty());
            int inti = Integer.parseInt(i);
            if (inti <= -928) {
                System.out.println("Значение Х должно быть больше -928");
                setMovieCoords();
            } else {
                String a;
                do{a= scan.readLine();}
                while(a.isEmpty());
                Float f = Float.parseFloat(i);
                if (f >= 982) {
                    System.out.println("Значение поля У должно быть меньше 982");
                    setMovieCoords();
                } else {
                    movie.setCoordinates(new Coordinates(inti, f));
                }
                }
            }catch (NumberFormatException |IOException e) {
            System.out.println("Несоответствие типов");
            setMovieCoords();
        }
    }


    public void setMovieGenre() throws IOException{
        System.out.println("Введите один из этих энамов, которые хрен знает за что отвечает, потому что я не знаю английский, простите"+"\n"+"WESTERN" +"\n" +"COMEDY"+"\n"+"MUSICAL"+"\n"+"SCIENCE_FICTION");
        String buf = scan.readLine().toLowerCase();
        switch (buf) {
            case "western":
                movie.setMovieGenre(MovieGenre.WESTERN);
                break;
            case "comedy":
                movie.setMovieGenre(MovieGenre.COMEDY);
                break;
            case "musical":
                movie.setMovieGenre(MovieGenre.MUSICAL);
                break;
            case "science_fiction":
                movie.setMovieGenre(MovieGenre.SCIENCE_FICTION);
                break;
            default:
                if (buf.isEmpty()){
                    movie.setMovieGenre(null);
                }
                else {
                    System.out.println("Пожалуйсто введите один из предложенных энамов");
                    setMovieGenre();
                }
        }
    }

    public void setMovieMpaaRating() throws IOException {
        System.out.println("Введите один из этих энамов, которые хрен знает за что отвечает, потому что я не знаю английский, простите"+"\n"+"G" +"\n" +"PG_13"+"\n"+"R"+"\n"+"NC_17");
        String buf;
        do{buf = scan.readLine().toLowerCase();}
        while(buf.isEmpty());
        switch (buf) {
            case "g":
                movie.setMpaaRating(MpaaRating.G);
                break;
            case "pg_13":
                movie.setMpaaRating(MpaaRating.PG_13);
                break;
            case "r":
                movie.setMpaaRating(MpaaRating.R);
                break;
            case "nc_13":
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


