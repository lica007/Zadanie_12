package ru.netology.statistic;

public class MovieManager {
    private int count;
    private MovieItem[] items = new MovieItem[0];

    public MovieManager() {
        this.count = 5;
    }

    public MovieManager(int count) {
        this.count = count;
    }

    public void addMovie(MovieItem item) {
        if (items.length < count) {
            MovieItem[] movie = new MovieItem[items.length + 1];
            for (int i = 0; i < items.length; i++) {
                movie[i] = items[i];
            }
            movie[movie.length - 1] = item;
            items = movie;
        }
    }

    public MovieItem[] findRev() {
        MovieItem[] all = findAll();
        MovieItem[] revorsed = new MovieItem[all.length];
        for (int i = 0; i < revorsed.length; i++) {
            revorsed[i] = all[all.length - 1 - i];
        }
        return revorsed;
    }

    public MovieItem[] findAll() {
        return items;
    }

    public MovieItem[] findLast() {
        int result;
        if (items.length < count){
            result = items.length;
        } else {
            result = count;
        }
        MovieItem[] movie = new MovieItem[result];
        for (int i = 0; i < movie.length; i++) {
            movie[i] = items[items.length - 1 - i];
        }
        return movie;
    }
}
