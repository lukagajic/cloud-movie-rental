package rs.ac.singidunum.fir.moviedataservice.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.moviedataservice.model.Movie;

import java.util.List;

@Repository
public class MovieDao {
  private final JdbcTemplate jdbcTemplate;

  public MovieDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Movie> getAllMovies() {
    String query = "SELECT * FROM movie";

    return jdbcTemplate.query(
      query, (resultSet, i) ->
        new Movie(
          resultSet.getInt("movie_id"),
          resultSet.getString("title"),
          resultSet.getString("description"),
          resultSet.getInt("year")
        )
    );
  }

  public Movie getMovieById(int movieId) {
    String query = "SELECT * FROM movie WHERE movie_id = ?";

    Movie foundMovie;

    try {
      foundMovie = jdbcTemplate.queryForObject(query, new Object[]{movieId}, ((resultSet, i) ->
        new Movie(
          resultSet.getInt("movie_id"),
          resultSet.getString("title"),
          resultSet.getString("description"),
          resultSet.getInt("year")
        )
      ));
    } catch (EmptyResultDataAccessException e) {
      foundMovie = null;
    }

    return foundMovie;
  }

  public int getMoviesCount() {
    String query = "SELECT COUNT(*) FROM movie";

    return jdbcTemplate.queryForObject(query, Integer.class);
  }

  public int getMovieYearById(int movieId) {
    String query = "SELECT year FROM movie WHERE movie_id = ?";

    int movieYear;

    try {
      movieYear = jdbcTemplate.queryForObject(query, new Object[]{movieId}, Integer.class);
    } catch (EmptyResultDataAccessException e) {
      movieYear = 0;
    }

    return movieYear;
  }

  public String getMovieTitleById(int movieId) {
    String query = "SELECT title FROM movie WHERE movie_id = ?";

    String movieTitle;

    try {
      movieTitle = jdbcTemplate.queryForObject(query, new Object[]{movieId}, String.class);
    } catch (Exception e) {
      movieTitle = "";
    }

    return movieTitle;
  }

  public String getMovieDescriptionById(int movieId) {
    String query = "SELECT description FROM movie WHERE movie_id = ?";

    String movieDescription;

    try {
      movieDescription = jdbcTemplate.queryForObject(query, new Object[]{movieId}, String.class);
    } catch (EmptyResultDataAccessException e) {
      movieDescription = "";
    }
    return movieDescription;
  }

  public Movie addNewMovie(Movie movie) {
    String query = "INSERT INTO movie (title, description, year) VALUES (?, ?, ?)";

    int insertStatus;
    Movie newMovie = null;


    try {
      insertStatus = jdbcTemplate.update(query, movie.getTitle(),
                                                movie.getDescription(),
                                                movie.getYear());
    } catch (Exception e) {
      insertStatus = 0;
    }

    if(insertStatus == 1) {
      newMovie = movie;
    }

    return newMovie;
  }

  public Movie updateMovieById(int movieId, Movie updatedMovie) {
    String query = "UPDATE movie " +
                   "SET title = ?, " +
                   "description = ?, " +
                   "year = ? " +
                   "WHERE movie_id = ?";

    int updateStatus;
    Movie movie = null;

    try {
      updateStatus = jdbcTemplate.update(query, updatedMovie.getTitle(),
                                                updatedMovie.getDescription(),
                                                updatedMovie.getYear(),
                                                movieId);
    } catch (Exception e) {
      updateStatus = 0;
    }

    if(updateStatus == 1) {
      movie = updatedMovie;
    }

    return updatedMovie;
  }

  public boolean deleteMovieById(int movieId) {
    String query = "DELETE FROM movie WHERE movie_id = ?";
    boolean isSuccessfullyDeleted = true;
    int deleteStatusCode;

    try {
      deleteStatusCode = jdbcTemplate.update(query, movieId);
    } catch (Exception e) {
      deleteStatusCode = 0;
    }

    if(deleteStatusCode != 1) {
      isSuccessfullyDeleted = false;
    }

    return isSuccessfullyDeleted;
  }

  public boolean isTableEmpty() {
    List<Movie> movies = getAllMovies();
    boolean isEmpty = false;

    if(movies.isEmpty()) {
      isEmpty = true;
    }

    return isEmpty;
  }

}
