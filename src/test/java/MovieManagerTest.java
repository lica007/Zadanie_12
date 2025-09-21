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
    MovieItem item7 = new MovieItem(7, "Тайна дома с часами", "Фэнтези");
    MovieItem item8 = new MovieItem(8, "Круиз по джунглям", "Приключение");
    MovieItem item9 = new MovieItem(9, "Плохие парни", "Комедия");

    @Test
    public void shouldDisplayFiveMoviesByDefault() { // Выводит по умолчанию 5 фильмов
        MovieManager movie = new MovieManager();
        movie.addMovie(item1);
        movie.addMovie(item2);
        movie.addMovie(item3);
        movie.addMovie(item4);
        movie.addMovie(item5);
        movie.addMovie(item6);
        movie.addMovie(item7);

        MovieItem[] expected = {item1, item2, item3, item4, item5};
        MovieItem[] actual = movie.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayFewerMoviesThanTheDefault() { // Выводит фильмы меньше чем указанно по умолчанию
        MovieManager movie = new MovieManager();
        movie.addMovie(item1);
        movie.addMovie(item2);
        movie.addMovie(item3);
        movie.addMovie(item4);

        MovieItem[] expected = {item1, item2, item3, item4};
        MovieItem[] actual = movie.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayFewerMoviesThanTheDefaultFindLast() { // Выводит фильмы меньше чем указанно по умолчанию в обратном порядке
        MovieManager movie = new MovieManager();
        movie.addMovie(item1);
        movie.addMovie(item2);
        movie.addMovie(item3);
        movie.addMovie(item4);

        MovieItem[] expected = {item4, item3, item2, item1};
        MovieItem[] actual = movie.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovie() { // Метод добавления
        MovieManager movie = new MovieManager();
        movie.addMovie(item1);
        movie.addMovie(item2);

        MovieItem[] expected = {item1, item2};
        MovieItem[] actual = movie.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOutputAnEmptyArray() { // Выводит пустой массив
        MovieManager movie = new MovieManager();

        MovieItem[] expected = {};
        MovieItem[] actual = movie.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovieAndFindLast() { // Выводит 5 фильмов по умолчанию в обратном порядке добавления
        MovieManager movie = new MovieManager();
        movie.addMovie(item3);
        movie.addMovie(item5);
        movie.addMovie(item1);
        movie.addMovie(item4);
        movie.addMovie(item2);
        movie.addMovie(item8);
        movie.addMovie(item7);

        MovieItem[] expected = {item2, item4, item1, item5, item3};
        MovieItem[] actual = movie.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void movieLessThanLimit() { // Выодит фильмы меньше установленной нормы
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
    public void movieLessThanLimitFindLast() { // Выодит фильмы меньше установленной нормы в обратном порядке
        MovieManager movie = new MovieManager(3);
        movie.addMovie(item3);
        movie.addMovie(item5);
        movie.addMovie(item1);
        movie.addMovie(item4);
        movie.addMovie(item2);
        movie.addMovie(item2);

        MovieItem[] expected = {item1, item5, item3};
        MovieItem[] actual = movie.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void movieMoreThanLimit() { // Выодит фильмы больше установленной нормы
        MovieManager movie = new MovieManager(8);
        movie.addMovie(item8);
        movie.addMovie(item5);
        movie.addMovie(item1);
        movie.addMovie(item4);
        movie.addMovie(item2);
        movie.addMovie(item6);
        movie.addMovie(item9);
        movie.addMovie(item7);
        movie.addMovie(item3);


        MovieItem[] expected = {item8, item5, item1, item4, item2, item6, item9, item7};
        MovieItem[] actual = movie.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void movieMoreThanLimitFindLast() { // Выодит фильмы больше установленной нормы в обрятном порядке
        MovieManager movie = new MovieManager(8);
        movie.addMovie(item8);
        movie.addMovie(item5);
        movie.addMovie(item1);
        movie.addMovie(item4);
        movie.addMovie(item2);
        movie.addMovie(item6);
        movie.addMovie(item9);
        movie.addMovie(item7);
        movie.addMovie(item3);


        MovieItem[] expected = {item7, item9, item6, item2, item4, item1, item5, item8};
        MovieItem[] actual = movie.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void movieEqualLimit() { // Выодит фильмы равные лимиту
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

    @Test
    public void movieEqualLimitFindLast() { // Выодит фильмы равные лимиту в обратном порядке
        MovieManager movie = new MovieManager(5);
        movie.addMovie(item3);
        movie.addMovie(item5);
        movie.addMovie(item6);
        movie.addMovie(item4);
        movie.addMovie(item2);
        movie.addMovie(item1);

        MovieItem[] expected = {item2, item4, item6, item5, item3};
        MovieItem[] actual = movie.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayMovieLessThanSpecified() { // Выодит фильмы меньше установленного колличества
        MovieManager movie = new MovieManager(4);
        movie.addMovie(item3);
        movie.addMovie(item5);
        movie.addMovie(item6);

        MovieItem[] expected = {item3, item5, item6};
        MovieItem[] actual = movie.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDisplayMovieLessThanSpecifiedFindLast() { // Выодит фильмы меньше установленного колличества в обратном порядк
        MovieManager movie = new MovieManager(4);
        movie.addMovie(item3);
        movie.addMovie(item5);
        movie.addMovie(item6);

        MovieItem[] expected = {item6, item5, item3};
        MovieItem[] actual = movie.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
