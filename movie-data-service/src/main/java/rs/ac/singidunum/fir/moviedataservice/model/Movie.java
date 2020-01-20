package rs.ac.singidunum.fir.moviedataservice.model;

public class Movie {
  private int movieId;
  private String title;
  private String description;
  private int year;

  public Movie() {

  }

  public Movie(int movieId, String title, String description, int year) {
    this.movieId = movieId;
    this.title = title;
    this.description = description;
    this.year = year;
  }

  public Movie(String title, String description, int year) {
    this.title = title;
    this.description = description;
    this.year = year;
  }

  public int getMovieId() {
    return movieId;
  }

  public void setMovieId(int movieId) {
    this.movieId = movieId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "Movie{" +
      "movieId=" + movieId +
      ", title='" + title + '\'' +
      ", description='" + description + '\'' +
      ", year=" + year +
      '}';
  }
}
