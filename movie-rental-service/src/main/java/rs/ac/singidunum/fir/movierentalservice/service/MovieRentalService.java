package rs.ac.singidunum.fir.movierentalservice.service;

import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.movierentalservice.dao.MovieRentalDao;
import rs.ac.singidunum.fir.movierentalservice.model.MovieRental;

import java.util.List;

@Service
public class MovieRentalService {
  private final MovieRentalDao movieRentalDao;

  public MovieRentalService(MovieRentalDao movieRentalDao) {
    this.movieRentalDao = movieRentalDao;
  }

  public List<MovieRental> getAllMovieRentals() {
    return movieRentalDao.getAllMovieRentals();
  }

  public List<MovieRental> getAllMovieRentalsByMovieId(int movieId) {
    return movieRentalDao.getAllMovieRentalsByMovieId(movieId);
  }

  public List<MovieRental> getAllMovieRentalsByUserId(int userId) {
    return movieRentalDao.getAllMovieRentalsByUserId(userId);
  }

  public MovieRental getMovieRentalById(int movieRentalId) {
    return movieRentalDao.getMovieRentalById(movieRentalId);
  }

  public int getTotalMovieRentalsCount() {
    return movieRentalDao.getTotalMovieRentalsCount();
  }

  public int getMovieRentalsCountByMovieId(int movieId) {
    return movieRentalDao.getMovieRentalsCountByMovieId(movieId);
  }

  public int getMovieRentalsCountByUserId(int userId) {
    return movieRentalDao.getMovieRentalsCountByUserId(userId);
  }

  public MovieRental addNewMovieRental(MovieRental movieRental) {
    return movieRentalDao.addNewMovieRental(movieRental);
  }

  public MovieRental updateMovieRentalById(int movieRentalId, MovieRental updatedMovieRental) {
    return movieRentalDao.updateMovieRentalById(movieRentalId, updatedMovieRental);
  }

  public boolean deleteMovieRentalById(int movieRentalId) {
    return movieRentalDao.deleteMovieRentalById(movieRentalId);
  }

}
