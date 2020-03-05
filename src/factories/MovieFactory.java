package factories;


import MovieClasses.*;
import java.io.*;
import java.util.*;

/**
 * Класс предоставляющий метод для создания готового и заполненного экземпляра класса Movie
 */

public class MovieFactory {
    private BufferedReader scan;
    private Movie movie;
    private ArrayList<String> par;
    private boolean script;
    public String path;
    public MovieFactory(){
        scan = new BufferedReader(new InputStreamReader(System.in));
        movie = new Movie();
    }
    public MovieFactory(BufferedReader scan){
        try {
            this.scan = scan;
            script = true;
            movie = new Movie();
        }catch(NullPointerException e){
            System.out.println("ploho");
        }
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
        if (par.size()>1){
            movie.setName((par.get(1)));
        }
        else {
            if(!script)System.out.println("Введите название фильма");
            String entered = scan.readLine().trim();
            if (!entered.isEmpty()) {
                movie.setName(entered);
            } else setMovieName();
        }
    }

    private void setMovieOscarCount(){
        try {
        if (par != null && par.size() > 2) {
            movie.setOscarsCount((Integer.parseInt(par.get(2))));}
            Integer result = null;
            while (result == null) {
                if(!script)System.out.println("Введите количество оскаров >0(Integer)");
                result = Integer.parseInt(scan.readLine().trim());
                if (result <= 0) {
                    if(!script)System.out.println("Введенное вами значение должно быть >0");
                    result = null;
                }
            }
            movie.setOscarsCount(result);
        }catch (NumberFormatException | NullPointerException | IOException e){
            if(!script)System.out.println("Введенное значение не того формата");
                if(par.size() > 2){
                par.remove(2);}
                setMovieOscarCount();
            }
    }


    private void setMovieCoordsX(Coordinates coords) {
        try{
        Integer result = null;
        while (result == null) {
            if(!script)System.out.println("Введите координату X(Integer)больше -928");
            result = Integer.parseInt(scan.readLine().trim());
            if (result <= -928) {
                if(!script)System.out.println("Введенное вами значение должно быть больше -928");
                result = null;
            }
        }
        coords.setX(result);
    }catch (NumberFormatException | NullPointerException | IOException e){
            if(!script)System.out.println("Введенное значение не того формата");
            setMovieCoordsX(coords);
        }
    }
    private void setMovieCoordsY(Coordinates coords){
        try{
            Float result = null;
            while (result == null) {
                if(!script)System.out.println("Введите координату Y(Float)меньше 982(не более 7 значащих цифр)");
                String str=scan.readLine().trim();
                if ((str.length() - str.replaceAll("\\d+", "").length())>7){
                    System.out.println("Сказано же 7");
                    throw new NumberFormatException();
                }
                else {
                    result = Float.parseFloat(str);
                    if (result >= 982) {
                        if (!script) System.out.println("Введенное вами значение должно быть меньше 982");
                        result = null;
                    }
                }
            }
            coords.setY(result);
        }catch (NumberFormatException | NullPointerException | IOException e){
            if(!script)System.out.println("Введенное значение не того формата");
            setMovieCoordsY(coords);
        }
    }

    private void setMovieGenre()  throws IOException{
        if(!script)System.out.println("Введите один из этих энамов, которые хрен знает за что отвечает, потому что я не знаю английский, простите"+"\n"+"WESTERN" +"\n" +"COMEDY"+"\n"+"MUSICAL"+"\n"+"SCIENCE_FICTION");
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
                    if(!script)System.out.println("Пожалуйсто введите один из предложенных энамов");
                    setMovieGenre();
                }
        }
    }

    private void setMovieMpaaRating() throws IOException {
        if(!script)System.out.println("Введите один из этих энамов, которые хрен знает за что отвечает, потому что я не знаю английский, простите"+"\n"+"G" +"\n" +"PG_13"+"\n"+"R"+"\n"+"NC_17");
        String buf;
        do{buf = scan.readLine().trim().toLowerCase();}
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
                if (!script)System.out.println("Пожалуйсто введите один из предложенных энамов");
                setMovieMpaaRating();
        }
    }

    private void setMoviePerson() throws IOException {
        if (script){
            movie.setPerson(new MoviePersonFactory(scan).createMoviePerson());
        }
        else{
        movie.setPerson(new MoviePersonFactory().createMoviePerson());
        }
    }
}


