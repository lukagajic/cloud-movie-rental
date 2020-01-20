package rs.ac.singidunum.fir.movierentalservice.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.movierentalservice.model.MovieRental;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRentalDao {
  private final JdbcTemplate jdbcTemplate;

  public MovieRentalDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<MovieRental> getAllMovieRentals() {
    String query = "SELECT * FROM movie_rental";

    return jdbcTemplate.query(
      query, (resultSet, i) ->
        new MovieRental(
          resultSet.getInt("movie_rental_id"),
          resultSet.getString("title"),
          resultSet.getInt("movie_id"),
          resultSet.getInt("user_id"),
          resultSet.getDate("starts_at"),
          resultSet.getDate("ends_at")
        )
    );
  }

  public List<MovieRental> getAllMovieRentalsByMovieId(int movieId) {
    String query = "SELECT * FROM movie_rental WHERE movie_id = ?";

    List<MovieRental> foundMovieRentals;

    try {
      foundMovieRentals = jdbcTemplate.query(
        query, new Object[]{movieId}, (resultSet, i) ->
          new MovieRental(
            resultSet.getInt("movie_rental_id"),
            resultSet.getString("title"),
            resultSet.getInt("movie_id"),
            resultSet.getInt("user_id"),
            resultSet.getDate("starts_at"),
            resultSet.getDate("ends_at")
          )
      );
    } catch (Exception e) {
      foundMovieRentals = new ArrayList<>();
    }

    return foundMovieRentals;
  }

  public List<MovieRental> getAllMovieRentalsByUserId(int userId) {
    String query = "SELECT * FROM movie_rental WHERE user_id = ?";

    List<MovieRental> foundMovieRentals;

    try {
      foundMovieRentals = jdbcTemplate.query(
        query, new Object[]{userId}, (resultSet, i) ->
          new MovieRental(
            resultSet.getInt("movie_rental_id"),
            resultSet.getString("title"),
            resultSet.getInt("movie_id"),
            resultSet.getInt("user_id"),
            resultSet.getDate("starts_at"),
            resultSet.getDate("ends_at")
          )
      );
    } catch (Exception e) {
      foundMovieRentals = new ArrayList<>();
    }

    return foundMovieRentals;
  }

  public MovieRental getMovieRentalById(int movieRentalId) {
    String query = "SELECT * FROM movie_rental WHERE movie_rental_id = ?";

    MovieRental foundMovieRental;

    try {
      foundMovieRental = jdbcTemplate.queryForObject(query, new Object[]{movieRentalId}, ((resultSet, i) ->
        new MovieRental(
          resultSet.getInt("movie_rental_id"),
          resultSet.getString("title"),
          resultSet.getInt("movie_id"),
          resultSet.getInt("user_id"),
          resultSet.getDate("starts_at"),
          resultSet.getDate("ends_at")
        )
      ));
    } catch (Exception e) {
      foundMovieRental = null;
    }

    return foundMovieRental;
  }

  public int getTotalMovieRentalsCount() {
    String query = "SELECT COUNT(*) FROM movie_rental";

    return jdbcTemplate.queryForObject(query, Integer.class);
  }

  public int getMovieRentalsCountByMovieId(int movieId) {
    String query = "SELECT COUNT(*) FROM movie_rental WHERE movie_id = ?";

    int movieRentalsCount;

    try {
      movieRentalsCount = jdbcTemplate.queryForObject(query, new Object[]{movieId}, Integer.class);
    } catch (Exception e) {
      movieRentalsCount = 0;
    }

    return movieRentalsCount;
  }

  public int getMovieRentalsCountByUserId(int userId) {
    String query = "SELECT COUNT(*) FROM movie_rental WHERE user_id = ?";

    int movieRentalsCount;

    try {
      movieRentalsCount = jdbcTemplate.queryForObject(query, new Object[]{userId}, Integer.class);
    } catch (Exception e) {
      movieRentalsCount = 0;
    }

    return movieRentalsCount;
  }

  public MovieRental addNewMovieRental(MovieRental movieRental) {
    String query = "INSERT INTO movie_rental (title, movie_id, user_id, starts_at, ends_at) VALUES (?, ?, ?, ?, ?)";

    int insertStatus;
    MovieRental newMovieRental = null;

    try {
      insertStatus = jdbcTemplate.update(query, movieRental.getTitle(),
                                                movieRental.getMovieId(),
                                                movieRental.getUserId(),
                                                movieRental.getStartsAt(),
                                                movieRental.getEndsAt());
    } catch (Exception e) {
      insertStatus = 0;
    }

    if(insertStatus == 1) {
      newMovieRental = movieRental;
    }

    return newMovieRental;
  }

  public MovieRental updateMovieRentalById(int movieRentalId, MovieRental updatedMovieRental) {
    String query = "UPDATE movie_rental " +
                   "SET title = ?, " +
                   "movie_id = ?, " +
                   "user_id = ?, " +
                   "starts_at = ?, " +
                   "ends_at = ? " +
                   "WHERE movie_rental_id = ?";

    int updateStatus;
    MovieRental movieRental = null;

    try {
      updateStatus = jdbcTemplate.update(query, updatedMovieRental.getTitle(),
                                                updatedMovieRental.getMovieId(),
                                                updatedMovieRental.getUserId(),
                                                updatedMovieRental.getStartsAt(),
                                                updatedMovieRental.getEndsAt(),
                                                movieRentalId);
    } catch (Exception e) {
      updateStatus = 0;
    }

    if(updateStatus == 1) {
      movieRental = updatedMovieRental;
    }

    return movieRental;
  }

  public boolean deleteMovieRentalById(int movieRentalId) {
    String query = "DELETE FROM movie_rental WHERE movie_rental_id = ?";
    boolean isSuccessfullyDeleted = true;
    int deleteStatusCode;

    try {
      deleteStatusCode = jdbcTemplate.update(query, movieRentalId);
    } catch (Exception e) {
      deleteStatusCode = 0;
    }

    if(deleteStatusCode != 1) {
      isSuccessfullyDeleted = false;
    }

    return isSuccessfullyDeleted;
  }

  public boolean isTableEmpty() {
    List<MovieRental> movieRentals = getAllMovieRentals();
    boolean isEmpty = false;

    if(movieRentals.isEmpty()) {
      isEmpty = true;
    }

    return isEmpty;
  }
}
