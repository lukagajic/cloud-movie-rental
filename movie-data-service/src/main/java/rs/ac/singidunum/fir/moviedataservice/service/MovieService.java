package rs.ac.singidunum.fir.moviedataservice.service;

import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.moviedataservice.dao.MovieDao;
import rs.ac.singidunum.fir.moviedataservice.model.Movie;

import java.util.List;

@Service
public class MovieService {
  private final MovieDao movieDao;

  public MovieService(MovieDao movieDao) {
    this.movieDao = movieDao;
  }

  // 1. getAllMovies()
  public List<Movie> getAllMovies() {
    return movieDao.getAllMovies();
  }

  // 2. getMovieById(movieId)
  public Movie getMovieById(int movieId) {
    return movieDao.getMovieById(movieId);
  }

  // 3. getMoviesCount()
  public int getMoviesCount() {
    return movieDao.getMoviesCount();
  }

  // 4. getMovieYearById(movieId)
  public int getMovieYearById(int movieId) {
    return movieDao.getMovieYearById(movieId);
  }

  // 5. getMovieTitleById(movieId)
  public String getMovieTitleById(int movieId) {
    return movieDao.getMovieTitleById(movieId);
  }

  // 6. getMovieDescriptionById(movieId)
  public String getMovieDescriptionById(int movieId) {
    return movieDao.getMovieDescriptionById(movieId);
  }

  // 7. addNewMovie(movie)
  public Movie addNewMovie(Movie movie) {
    return movieDao.addNewMovie(movie);
  }

  // 8. updateMovieById(movieId)
  public Movie updateMovieById(int movieId, Movie updatedMovie) {
    return movieDao.updateMovieById(movieId, updatedMovie);
  }

  // 9. deleteMovieById(movieId)
  public boolean deleteMovieById(int movieId) {
    return movieDao.deleteMovieById(movieId);
  }

  // 10. isTableEmpty()
  public boolean isTableEmpty() {
    return movieDao.isTableEmpty();
  }
}
