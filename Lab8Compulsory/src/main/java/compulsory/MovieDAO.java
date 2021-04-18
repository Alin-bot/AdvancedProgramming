package compulsory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    public Movie findById(Integer id) throws SQLException {
        Movie movie = new Movie();
        Singleton sing = new Singleton();

        PreparedStatement stmt = sing.con.prepareStatement("SELECT * FROM movies WHERE id = ?");
        stmt.setInt(1, id);
        ResultSet result = stmt.executeQuery();

        while(result.next()) {
            movie.id = result.getInt("id");
            movie.title = result.getString("title");
            movie.releaseDate = result.getDate("release_date");
            movie.duration = result.getDouble("duration");
            movie.score = result.getDouble("score");
        }

        return movie;
    }

    public List<Movie> findByName(String title) throws SQLException {
        List<Movie> movieList = new ArrayList<>();
        Singleton sing = new Singleton();

        PreparedStatement stmt = sing.con.prepareStatement("SELECT * FROM movies WHERE title = ?");
        stmt.setString(1, title);
        ResultSet result = stmt.executeQuery();

        while(result.next()) {
            Movie movie = new Movie();

            movie.id = result.getInt("id");
            movie.title = result.getString("title");
            movie.releaseDate = result.getDate("release_date");
            movie.duration = result.getDouble("duration");
            movie.score = result.getDouble("score");

            movieList.add(movie);
        }

        return movieList;
    }

    public void addMovie(Movie movie) throws SQLException {
        Singleton sing = new Singleton();

        sing.con.setAutoCommit(false);

        PreparedStatement stmt = sing.con.prepareStatement("INSERT INTO movies VALUES (?,?,?,?,?)");
        stmt.setInt(1, movie.id);
        stmt.setString(2, movie.title);
        stmt.setDate(3, (Date) movie.releaseDate);
        stmt.setDouble(4, movie.duration);
        stmt.setDouble(5, movie.score);
        stmt.executeUpdate();

        sing.con.commit();
        sing.con.setAutoCommit(true);
    }
}
