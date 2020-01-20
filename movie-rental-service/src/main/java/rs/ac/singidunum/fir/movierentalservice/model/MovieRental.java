package rs.ac.singidunum.fir.movierentalservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MovieRental {
  private int movieRentalId;
  private String title;
  private int movieId;
  private int userId;

  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Belgrade")
  private Date startsAt;

  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Belgrade")
  private Date endsAt;

  public MovieRental() {

  }

  public MovieRental(int movieRentalId, String title, int movieId, int userId, Date startsAt, Date endsAt) {
    this.movieRentalId = movieRentalId;
    this.title = title;
    this.movieId = movieId;
    this.userId = userId;
    this.startsAt = startsAt;
    this.endsAt = endsAt;
  }

  public MovieRental(String title, int movieId, int userId, Date startsAt, Date endsAt) {
    this.title = title;
    this.movieId = movieId;
    this.userId = userId;
    this.startsAt = startsAt;
    this.endsAt = endsAt;
  }

  public int getMovieRentalId() {
    return movieRentalId;
  }

  public void setMovieRentalId(int movieRentalId) {
    this.movieRentalId = movieRentalId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getMovieId() {
    return movieId;
  }

  public void setMovieId(int movieId) {
    this.movieId = movieId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public Date getStartsAt() {
    return startsAt;
  }

  public void setStartsAt(Date startsAt) {
    this.startsAt = startsAt;
  }

  public Date getEndsAt() {
    return endsAt;
  }

  public void setEndsAt(Date endsAt) {
    this.endsAt = endsAt;
  }

  @Override
  public String toString() {
    return "MovieRental{" +
      "movieRentalId=" + movieRentalId +
      ", title='" + title + '\'' +
      ", movieId=" + movieId +
      ", userId=" + userId +
      ", startsAt=" + startsAt +
      ", endsAt=" + endsAt +
      '}';
  }
}
