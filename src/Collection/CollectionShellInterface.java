package Collection;

import MovieClasses.Movie;
import WorkWithFile.FileWorker;
import WorkWithFile.ID;
import WorkWithFile.Parser;
import factories.MovieFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public interface CollectionShellInterface {
    void add(Movie movie);
    void clear();
    void save(Parser parser,FileWorker id) throws FileNotFoundException;
    void Remove_by_id();
    void show();
    void info();
    void updateByID(Long id, MovieFactory mf) throws IOException;
}
