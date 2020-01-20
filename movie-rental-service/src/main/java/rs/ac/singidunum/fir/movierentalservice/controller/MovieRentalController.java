package rs.ac.singidunum.fir.movierentalservice.controller;

import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.fir.movierentalservice.model.MovieRental;
import rs.ac.singidunum.fir.movierentalservice.service.MovieRentalService;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class MovieRentalController {
  private final MovieRentalService movieRentalService;

  public MovieRentalController(MovieRentalService movieRentalService) {
    this.movieRentalService = movieRentalService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<MovieRental> getAllMovieRentals() {
    return movieRentalService.getAllMovieRentals();
  }

  @RequestMapping(method = RequestMethod.GET, path = "/all/movie-id/{movieId}")
  public List<MovieRental> getAllMovieRentalsByMovieId(@PathVariable int movieId) {
    return movieRentalService.getAllMovieRentalsByMovieId(movieId);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/all/user-id/{userId}")
  public List<MovieRental> getAllMovieRentalsByUserId(@PathVariable int userId) {
    return movieRentalService.getAllMovieRentalsByUserId(userId);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/id/{movieRentalId}")
  public MovieRental getMovieRentalById(@PathVariable int movieRentalId) {
    return movieRentalService.getMovieRentalById(movieRentalId);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/count")
  public int getTotalMovieRentalsCount() {
    return movieRentalService.getTotalMovieRentalsCount();
  }

  @RequestMapping(method = RequestMethod.GET, path = "/count/movie-id/{movieId}")
  public int getMovieRentalsCountByMovieId(@PathVariable int movieId) {
    return movieRentalService.getMovieRentalsCountByMovieId(movieId);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/count/user-id/{userId}")
  public int getMovieRentalsCountByUserId(@PathVariable int userId) {
    return movieRentalService.getMovieRentalsCountByUserId(userId);
  }

  @RequestMapping(method = RequestMethod.POST)
  public MovieRental addNewMovieRental(@RequestBody MovieRental movieRental) {
    return movieRentalService.addNewMovieRental(movieRental);
  }

  @RequestMapping(method = RequestMethod.PUT, path ="/id/{movieRentalId}")
  public MovieRental updateMovieRentalById(@PathVariable int movieRentalId, @RequestBody MovieRental updatedMovieRental) {
    return movieRentalService.updateMovieRentalById(movieRentalId, updatedMovieRental);
  }

  @RequestMapping(method = RequestMethod.DELETE, path = "/id/{movieRentalId}")
  public boolean deleteMovieRentalById(@PathVariable int movieRentalId) {
    return movieRentalService.deleteMovieRentalById(movieRentalId);
  }

}
