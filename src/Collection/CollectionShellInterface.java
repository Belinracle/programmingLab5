package Collection;

import MovieClasses.Movie;
import factories.MovieFactory;

import java.io.IOException;
import java.time.LocalDate;

public interface CollectionShellInterface {
    void add(Movie movie);
    void clear();
    void Remove_by_id();
    void show();
    void info();
    void updateByID(Long id, MovieFactory mf) throws IOException;
}
