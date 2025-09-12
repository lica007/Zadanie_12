import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.statistic.MovieItem;
import ru.netology.statistic.MovieManager;

public class MovieManagerTest {

    MovieItem item1 = new MovieItem(1, "Джентельмены", "Боевик");
    MovieItem item2 = new MovieItem(2, "Белые цыпочки", "Комедия");
    MovieItem item3 = new MovieItem(3, "Достать ножи", "Детектив");
    MovieItem item4 = new MovieItem(4, "Как приручить дракона", "Мультик");
    MovieItem item5 = new MovieItem(5, "Валериан и город тысячи планет", "Фантастика");
    MovieItem item6 = new MovieItem(6, "Нерв", "Триллер");

    @Test
    public void shouldAddMovie() {
        MovieManager movie = new MovieManager();
        movie.addMovie(item1);
        movie.addMovie(item2);
        movie.addMovie(item3);
        movie.addMovie(item4);
        movie.addMovie(item5);

        MovieItem[] expected = {item1, item2, item3, item4, item5};
        MovieItem[] actual = movie.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovieAndFindLast() {
        MovieManager movie = new MovieManager();
        movie.addMovie(item3);
        movie.addMovie(item5);
        movie.addMovie(item1);
        movie.addMovie(item4);
        movie.addMovie(item2);
        movie.addMovie(item2);

        MovieItem[] expected = {item2, item4, item1, item5, item3};
        MovieItem[] actual = movie.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void movieLessThanLimit() {
        MovieManager movie = new MovieManager(3);
        movie.addMovie(item3);
        movie.addMovie(item5);
        movie.addMovie(item1);
        movie.addMovie(item4);
        movie.addMovie(item2);
        movie.addMovie(item2);

        MovieItem[] expected = {item3, item5, item1};
        MovieItem[] actual = movie.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void movieMoreThanLimit() {
        MovieManager movie = new MovieManager(10);
        movie.addMovie(item3);
        movie.addMovie(item5);
        movie.addMovie(item1);
        movie.addMovie(item4);
        movie.addMovie(item2);
        movie.addMovie(item6);

        MovieItem[] expected = {item3, item5, item1, item4, item2, item6};
        MovieItem[] actual = movie.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void movieEqualLimit() {
        MovieManager movie = new MovieManager(5);
        movie.addMovie(item3);
        movie.addMovie(item5);
        movie.addMovie(item6);
        movie.addMovie(item4);
        movie.addMovie(item2);
        movie.addMovie(item1);

        MovieItem[] expected = {item3, item5, item6, item4, item2};
        MovieItem[] actual = movie.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
