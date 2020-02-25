package Collection;

import MovieClasses.Movie;
import Parsers.Parser;
import factories.MovieFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Collection;

public class DequeMovieCollection implements CollectionShellInterface{
    ArrayDeque<Movie> cal;
    LocalDate creationDate;
    ArrayDeque<Movie> buf;
    public DequeMovieCollection(){
        cal=new ArrayDeque<>();
        creationDate = LocalDate.now();
        buf=new ArrayDeque<>();
    }

    @Override
    public void add(Movie movie) {
        cal.add(movie);
    }

    @Override
    public void clear() {
        cal.clear();
    }


    @Override
    public void Remove_by_id() {

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
    public void updateByID(Long id, MovieFactory mf) throws IOException {
        while(cal.peekLast().getID()!=id){
            buf.addFirst(cal.removeLast());
        }
        cal.removeLast();
        cal.addLast(mf.updateID(id));
        while( buf.size()!=0){
            cal.addLast(buf.removeFirst());
        }
    }

    @Override
    public Collection<Movie> getCol() {
        return cal;
    }

    @Override
    public void save(Parser parser) throws FileNotFoundException {
       //.write();
    }

}
