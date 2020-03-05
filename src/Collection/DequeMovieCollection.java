package Collection;

import MovieClasses.Movie;
import MovieClasses.MpaaRating;
import MovieClasses.Person;
import factories.MovieFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * реализация интерефейса для работы с ArrayDeque
 */
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
        System.out.println("Коллекция очищена");
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
    public void updateByID(Long id, BufferedReader reader) throws IOException {
        try {
            while (cal.getLast().getID() != id) {
                buf.addFirst(cal.removeLast());
            }
            cal.removeLast();
            if (reader!=null){
                add(new MovieFactory(reader).updateID(id));
            }
            else {
                add(new MovieFactory().updateID(id));
            }
                while (buf.size() != 0) {
                    cal.addLast(buf.removeFirst());
                }
            }catch (NoSuchElementException e){
            System.out.println("В коллекции нет Фильма с таким ID");
            cal.addAll(buf);
            buf.clear();
        }catch(NullPointerException e){
            System.out.println("Скрипт плохой, давай по новой");
            cal.addAll(buf);
            buf.clear();
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
            System.out.println("Коллекция пуста, добавлю элемент");
            cal.addLast(movie);
        }
    }

    @Override
    public void addIfMin(Movie movie) {
        try {
            if (cal.getFirst().getName().compareToIgnoreCase(movie.getName()) > 0) {
                cal.addLast(movie);
            }
        }catch (NoSuchElementException e){
            System.out.println("Коллекция пуста, добавлю элемент");
            cal.addFirst(movie);
        }
    }

    @Override
    public void removeAllBySc(Person person) {
        try {
            List<Long> toDel = cal.stream().filter(x->x.getScreenwriter().equals(person)).map(Movie::getID).collect(Collectors.toList());
            toDel.forEach(this::removeByID);
            System.out.println("Команда выполнена");
        }catch (NullPointerException e){
            System.out.println("плохо");
        }
    }

    @Override
    public void countByMpaaRating(MpaaRating rating) {
        System.out.println("Количество фильмов с этим MpaaRating= "+cal.stream().filter(x->x.getMpaaRating()==rating).count());
    }

    @Override
    public void printAscending() {
        for(Movie mov:cal){
            System.out.println(mov.getName());
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
