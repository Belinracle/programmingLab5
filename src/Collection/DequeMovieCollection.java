package Collection;

import MovieClasses.Movie;

import java.util.ArrayDeque;

public class DequeMovieCollection implements CollectionShellInterface{
    ArrayDeque<Movie> cal;
    public DequeMovieCollection(){
        cal=new ArrayDeque<>();
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
    public String toString() {
        return cal.toString();
    }
}
