package Collection;

import MovieClasses.Movie;
import MovieClasses.Person;
import Parsers.Parser;
import factories.MovieFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DequeMovieCollection implements CollectionShellInterface{
    private ArrayDeque<Movie> cal;
    private LocalDate creationDate;
    private ArrayDeque<Movie> buf;
    public DequeMovieCollection(){
        cal=new ArrayDeque<>();
        creationDate = LocalDate.now();
        buf=new ArrayDeque<>();
    }

    @Override
    public void clear() {
        cal.clear();
    }

    @Override
    public void show() {
        cal.forEach(System.out::println);
    }
    public ArrayDeque getCal(){
        return cal;
    }

    @Override
    public void info() {
        System.out.println("Тип Коллекции: Collection    "+"Время создания: "+creationDate+ "  Количество элементов в коллекции: "+cal.size());
    }

    @Override
    public void updateByID(Long id) throws IOException {
        try {
            while (cal.getLast().getID() != id) {
                buf.addFirst(cal.removeLast());
            }
                cal.removeLast();
                add(new MovieFactory().updateID(id));
                while (buf.size() != 0) {
                    cal.addLast(buf.removeFirst());
                }
            }catch (NoSuchElementException e){
            System.out.println("В коллекции нет Фильма с таким ID");
            cal.addAll(buf);
        }
    }

    @Override
    public Collection<Movie> getCol() {
        return cal;
    }

    @Override
    public void removeByID(Long id) {
        try {
            while (cal.getLast().getID() != id) {
                buf.addFirst(cal.removeLast());
            }
            cal.removeLast();
            cal.addAll(buf);
            buf.clear();
        }catch(NoSuchElementException |NullPointerException e){
            System.out.println("Элемента с таким ID нет в коллекции");
        }
    }

    @Override
    public void removeFirst() {
        try {
            cal.removeFirst();
        }catch(NoSuchElementException e){
            System.out.println("Коллекция пуста");
        }
    }

    @Override
    public void addIfMax(Movie movie) {
        try {
            if (cal.getLast().getName().compareToIgnoreCase(movie.getName()) < 0) {
                cal.addLast(movie);
            }
        }catch (NoSuchElementException e){
            System.out.println("Коллекция пуста");
        }
    }

    @Override
    public void addIfMin(Movie movie) {
        try {
            if (cal.getFirst().getName().compareToIgnoreCase(movie.getName()) > 0) {
                cal.addLast(movie);
            }
        }catch (NoSuchElementException e){
            System.out.println("Коллекция пуста");
        }
    }

    @Override
    public void removeAllBySc(Person person) {
        try {
            ArrayList<Long> toDel = new ArrayList<>();
            for (Movie movie : cal) {
                System.out.println("tak blya");
                if (movie.getScreenwriter().equals(person)) {
                    System.out.println("tak blya");
                    toDel.add(movie.getID());
                }
            }
            for (Long id : toDel) {
                removeByID(id);
            }
        }catch (NullPointerException e){
            System.out.println("u blya");
        }
    }


    @Override
    public void add(Movie movie) {
            while (cal.size()!=0&&cal.getLast().getName().compareToIgnoreCase(movie.getName()) > 0) {
                buf.addFirst(cal.removeLast());
            }
            cal.addLast(movie);
            cal.addAll(buf);
            buf.clear();
    }

}
