package Collection;

import MovieClasses.Movie;
import MovieClasses.MpaaRating;
import MovieClasses.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

/**
 * интерфейс для работы с любой реализации коллекции
 */
public interface CollectionShellInterface {
    void add(Movie movie);
    void clear();
    void show();
    void info();
    void updateByID(Long id, BufferedReader reader) throws IOException;
    Collection getCol();
    void removeByID(Long id);
    void removeFirst();
    void addIfMax(Movie movie);
    void addIfMin(Movie movie);
    void removeAllBySc(Person person);
    void countByMpaaRating(MpaaRating rating);
    void printAscending();
}
