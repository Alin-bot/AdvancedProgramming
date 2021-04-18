package compulsory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenresDAO {

    public Genre findById(Integer id) throws SQLException {
        Genre genre = new Genre();
        Singleton sing = new Singleton();

        PreparedStatement stm = sing.con.prepareStatement("SELECT * FROM genres WHERE id = ?");
        stm.setInt(1, id);
        ResultSet result = stm.executeQuery();

        while(result.next()) {
            genre.id = result.getInt("id");
            genre.name = result.getString("name");
        }

        return genre;
    }

    public List<Genre> findByName(String name) throws SQLException {
        List<Genre> genresList = new ArrayList<>();
        Singleton sing = new Singleton();

        PreparedStatement stm = sing.con.prepareStatement("SELECT * FROM genres WHERE name = ?");
        stm.setString(1, name);
        ResultSet result = stm.executeQuery();

        while(result.next()) {
            Genre genre = new Genre();

            genre.id = result.getInt("id");
            genre.name = result.getString("name");

            genresList.add(genre);
        }

        return genresList;
    }

    public void addGenre(Genre genre) throws SQLException {
        Singleton sing = new Singleton();

        sing.con.setAutoCommit(false);

        PreparedStatement stmt = sing.con.prepareStatement("INSERT INTO genres VALUES (?,?)");
        stmt.setInt(1, genre.id);
        stmt.setString(2, genre.name);
        stmt.executeUpdate();

        sing.con.commit();
        sing.con.setAutoCommit(true);
    }
}
