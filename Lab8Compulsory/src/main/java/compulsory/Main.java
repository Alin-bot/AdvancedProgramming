package compulsory;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static java.sql.Types.NULL;

public class Main {
    public static void main(String[] args) throws SQLException {

        Singleton sing = Singleton.getInstance();

        try {
            MovieDAO movieDAO = new MovieDAO();
            GenresDAO genresDAO = new GenresDAO();

            // search by id and name some movies
            Movie movie = movieDAO.findById(2);
            System.out.println(movie.toString());
            List movieList = movieDAO.findByName("Avengers: Endgame");
            System.out.println(movieList);

            // search my id and name some genres
            Genre genre = genresDAO.findById(1);
            System.out.println(genre.toString());
            List genresList = genresDAO.findByName("action");
            System.out.println(genresList);

/*          // adding new movie
            Movie myMovie = new Movie(NULL, "The Avengers", Date.valueOf("2012-05-04"), 224.0, 8.0);
            movieDAO.addMovie(myMovie);

            // adding new genre
            Genre myGenre = new Genre(NULL, "comedy");
            genresDAO.addGenre(myGenre);
*/

            CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/IMDb movies.csv"));
            String[] next;
            int max = 5;
            int index;
            while((next = csvReader.readNext()) != null && max != 0) {
                index = 0;

                if (max != 5) {
                    Movie temporaryMovie = new Movie();
                    Genre temporaryGenre = new Genre();
                    Actor temporaryActor = new Actor();
                    Director temporaryDirector = new Director();

                    for (String element : next) {
                        switch (index) {
                            case 1 -> {
                                temporaryMovie.id = NULL;
                                temporaryMovie.title = element;
                            }
                            case 4 -> temporaryMovie.releaseDate = Date.valueOf(element);
                            case 5 -> {
                                temporaryGenre.id = NULL;
                                temporaryGenre.name = element;
                            }
                            case 6 -> temporaryMovie.duration = Double.valueOf(element);
                            case 9 -> temporaryDirector.name = element;
                            case 12 -> temporaryActor.name = element;
                            case 14 -> temporaryMovie.score = Double.valueOf(element);
                        }
                        index++;
                    }
                    movieDAO.addMovie(temporaryMovie);
                    genresDAO.addGenre(temporaryGenre);
                }
                max--;
            }


        } catch(SQLException | IOException e) {
            System.err.println("Cannot connect to DB: " + e);
        } finally {
            if (sing.con != null) sing.con.close() ;
        }
    }
}
