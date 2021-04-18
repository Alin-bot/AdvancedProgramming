package compulsory;

import java.util.Date;

public class Movie {

    int id;
    String title;
    Date releaseDate;
    Double duration;
    Double score;

    public Movie() {

    }

    public Movie(int id, String title, Date releaseDate, Double duration, Double score) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", releaseDate = " + releaseDate +
                ", duration = " + duration +
                ", score = " + score +
                '}';
    }
}
