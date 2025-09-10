package ru.netology.statistic;

public class MovieItem {
    private int id;
    private String nameMovie;
    private String genreMovie;

    public MovieItem(int id, String nameMovie, String genreMovie) {
        this.id = id;
        this.nameMovie = nameMovie;
        this.genreMovie = genreMovie;
    }

    public int getId() {
        return id;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public String getGenreMovie() {
        return genreMovie;
    }
}
