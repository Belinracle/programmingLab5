package factories;


import MovieClasses.*;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class MovieFactory {
    private BufferedReader scan;
    private Movie movie;
    private ArrayList<String> par;
    public MovieFactory(){
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        scan = new BufferedReader(inputStreamReader);
        movie = new Movie();
    }

    public Movie createMovie(ArrayList<String> T) throws IOException {
        par=T;
        movie.setID(IDFactory.createID());
        setMovieName();
        setMovieOscarCount();
        Coordinates coords = new Coordinates();
        setMovieCoordsX(coords);
        setMovieCoordsY(coords);
        movie.setCoordinates(coords);
        setMovieGenre();
        setMovieMpaaRating();
        setMoviePerson();
        System.out.println("Спасибо, фильм создан");
        return movie;
    }
    public Movie updateID(Long ID) throws IOException {
        movie.setID(ID);
        setMovieName();
        setMovieOscarCount();
        Coordinates coords = new Coordinates();
        setMovieCoordsX(coords);
        setMovieCoordsY(coords);
        movie.setCoordinates(coords);
        setMovieGenre();
        setMovieMpaaRating();
        setMoviePerson();
        System.out.println("Спасибо, фильм создан");
        return movie;
    }

    private void setMovieName() throws IOException {
        if (par!=null){
            movie.setName((par.get(1)));
        }
        else {
            System.out.println("Введите название фильма");
            String entered = scan.readLine().trim();
                if (!entered.isEmpty()) {
                    movie.setName(entered);
                } else setMovieName();
        }
    }

    private void setMovieOscarCount(){
        if (par!=null&&par.size()>2){
            movie.setOscarsCount((Integer.parseInt(par.get(2))));
        }
        else
        {
            System.out.println("Введите количество оскаров фильма(должно быть больше 0)");
            try {
                String entered=scan.readLine().trim();
                while (entered.isEmpty()){
                    setMovieOscarCount();
                }
                int result =Integer.parseInt(entered);
                if(result<0){
                    System.out.println("Введенное вами значение должно быть больше 0");
                    setMovieOscarCount();
                }
                else movie.setOscarsCount(result);
            }catch (NumberFormatException | IOException e){
                System.out.println("Введеное значение не того формата");
                setMovieOscarCount();
            }
        }
    }

    private void setMovieCoordsX(Coordinates coords) {
        System.out.println("Введите значение координаты Х(должно быть больше -928)");
        try {
            String entered = scan.readLine().trim();
            while (entered.isEmpty()) {
                setMovieCoordsX(coords);
            }
            Integer result = Integer.parseInt(entered);
            if (result < -928) {
                System.out.println("Введенное вами значение должно быть больше -928");
                setMovieCoordsX(coords);
            } else coords.setX(result);
        } catch (NumberFormatException | IOException e) {
            System.out.println("Введеное значение не того формата");
            setMovieCoordsX(coords);
        }
    }
    private void setMovieCoordsY(Coordinates coords){
            System.out.println("Введите значение координаты Y(должно быть меньше 982)");
            try {
                String entered=scan.readLine().trim();
                while (entered.isEmpty()){
                    setMovieCoordsY(coords);
                }
                float result=Float.parseFloat(entered);
                if(result>982){
                    System.out.println("Введенное вами значение должно быть меньше 982");
                    setMovieCoordsY(coords);
                }
                else   coords.setY(result);
            }catch (NumberFormatException | IOException e) {
                System.out.println("Введеное значение не того формата");
                setMovieCoordsY(coords);
            }
    }




    private void setMovieGenre(){
        System.out.println("Введите один из этих энамов, которые хрен знает за что отвечает, потому что я не знаю английский, простите"+"\n"+"WESTERN" +"\n" +"COMEDY"+"\n"+"MUSICAL"+"\n"+"SCIENCE_FICTION");
        Scanner scan=new Scanner(System.in);
        String buf = scan.nextLine().toLowerCase();
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

    private void setMovieMpaaRating() {
        System.out.println("Введите один из этих энамов, которые хрен знает за что отвечает, потому что я не знаю английский, простите"+"\n"+"G" +"\n" +"PG_13"+"\n"+"R"+"\n"+"NC_17");
        String buf;
        Scanner scan = new Scanner(System.in);
        do{buf = scan.nextLine().trim().toLowerCase();}
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

    private void setMoviePerson() {
        movie.setPerson(new MoviePersonFactory().createMoviePerson());
    }
}


