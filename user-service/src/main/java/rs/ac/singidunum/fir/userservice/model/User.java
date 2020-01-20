package rs.ac.singidunum.fir.userservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {
    private int userId;
    private String username;
    private String email;
    private String forename;
    private String surname;
    private int isActive;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Belgrade")
    private Date bornAt;

    public User() {

    }

    public User(int userId, String username, String email, String forename, String surname, Date bornAt, int isActive) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.forename = forename;
        this.surname = surname;
        this.bornAt = bornAt;
        this.isActive = isActive;
    }

    public User(String username, String email, String forename, String surname, Date bornAt, int isActive) {
        this.username = username;
        this.email = email;
        this.forename = forename;
        this.surname = surname;
        this.bornAt = bornAt;
        this.isActive = isActive;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBornAt() {
        return bornAt;
    }

    public void setBornAt(Date bornAt) {
        this.bornAt = bornAt;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", isActive=" + isActive +
                ", bornAt=" + bornAt +
                '}';
    }
}
