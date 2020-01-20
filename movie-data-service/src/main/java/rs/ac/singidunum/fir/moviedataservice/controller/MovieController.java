package rs.ac.singidunum.fir.moviedataservice.controller;

import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.fir.moviedataservice.model.Movie;
import rs.ac.singidunum.fir.moviedataservice.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  // 1. localhost:8080/movies/
  @RequestMapping(method = RequestMethod.GET)
  public List<Movie> getAllMovies() {
    return movieService.getAllMovies();
  }

  // 2. localhost:8080/movies/id/{movieId}
  @RequestMapping(method = RequestMethod.GET, path = "/id/{movieId}")
  public Movie getMovieById(@PathVariable int movieId) {
    return movieService.getMovieById(movieId);
  }

  // 3. localhost:8080/movies/count
  @RequestMapping(method = RequestMethod.GET, path = "/count")
  public int getMoviesCount() {
    return movieService.getMoviesCount();
  }

  // 4. localhost:8080/movies/year/id/{movieId}
  @RequestMapping(method = RequestMethod.GET, path = "/year/id/{movieId}")
  public int getMovieYearById(@PathVariable int movieId) {
    return movieService.getMovieYearById(movieId);
  }

  // 5. localhost:8080/movies/title/id/{movieId}
  @RequestMapping(method = RequestMethod.GET, path ="/title/id/{movieId}")
  public String getMovieTitleById(@PathVariable int movieId) {
    return movieService.getMovieTitleById(movieId);
  }

  // 6. localhost:8080/movies/description/id/{movieId}
  @RequestMapping(method = RequestMethod.GET, path = "/description/id/{movieId}")
  public String getMovieDescriptionById(@PathVariable int movieId) {
    return movieService.getMovieDescriptionById(movieId);
  }

  // 7. localhost:8080/movies/
  @RequestMapping(method = RequestMethod.POST)
  public Movie addNewMovie(@RequestBody Movie movie) {
    return movieService.addNewMovie(movie);
  }

  // 8. localhost:8080/movies/id/{movieId}
  @RequestMapping(method = RequestMethod.PUT, path = "/id/{movieId}")
  public Movie updateMovieById(@PathVariable int movieId, @RequestBody Movie updatedMovie) {
    return movieService.updateMovieById(movieId, updatedMovie);
  }

  // 9. localhost:8080/movies/id/{movieId}
  @RequestMapping(method = RequestMethod.DELETE, path = "/id/{movieId}")
  public boolean deleteMovieById(@PathVariable int movieId) {
    return movieService.deleteMovieById(movieId);
  }

  // 10. localhost:8080/movies/is-empty
  @RequestMapping(method = RequestMethod.GET, path = "/is-empty")
  public boolean isTableEmpty() {
    return movieService.isTableEmpty();
  }
}
