package Collection;

import MovieClasses.Movie;
import MovieClasses.Person;
import Parsers.Parser;
import factories.MovieFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

public interface CollectionShellInterface {
    void add(Movie movie);
    void clear();
    void show();
    void info();
    void updateByID(Long id) throws IOException;
    Collection getCol();
    void removeByID(Long id);
    void removeFirst();
    void addIfMax(Movie movie);
    void addIfMin(Movie movie);
    void removeAllBySc(Person person);
}
