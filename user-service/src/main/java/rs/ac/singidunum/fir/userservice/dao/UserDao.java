package rs.ac.singidunum.fir.userservice.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.fir.userservice.model.User;

import java.util.List;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers() {
        String query = "SELECT * FROM `user`";

        return jdbcTemplate.query(
            query, (resultSet, i) ->
                new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("forename"),
                        resultSet.getString("surname"),
                        resultSet.getDate("born_at"),
                        resultSet.getInt("is_active")
                )
        );
    }

    public User getUserById(int userId) {
        String query = "SELECT * FROM `user` WHERE user_id = ?";

        User foundUser;

        try {
            foundUser = jdbcTemplate.queryForObject(query, new Object[]{userId}, ((resultSet, i) ->
              new User(
                resultSet.getInt("user_id"),
                resultSet.getString("username"),
                resultSet.getString("email"),
                resultSet.getString("forename"),
                resultSet.getString("surname"),
                resultSet.getDate("born_at"),
                resultSet.getInt("is_active")
            )));
        } catch (EmptyResultDataAccessException e) {
            foundUser = null;
        }

        return foundUser;
    }

    public User getUserByUsername(String username) {
        String query = "SELECT * FROM `user` WHERE username = ?";

        User foundUser;

        try {
            foundUser =  jdbcTemplate.queryForObject(query, new Object[]{username}, ((resultSet, i) -> new User(
                    resultSet.getInt("user_id"),
                    resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getString("forename"),
                    resultSet.getString("surname"),
                    resultSet.getDate("born_at"),
                    resultSet.getInt("is_active")
            )));
        } catch (Exception e) {
            foundUser = null;
        }

        return foundUser;
    }

    public int getUsersCount() {
        String query = "SELECT COUNT(*) FROM `user`";

        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public boolean isUserActiveUsingUserId(int userId) {
        String query = "SELECT is_active FROM `user` WHERE user_id = ?";

        int activityStatus;
        boolean isActive = true;

        try {
          activityStatus = jdbcTemplate.queryForObject(query, new Object[]{userId}, Integer.class);
        } catch (Exception e) {
          activityStatus = 0;
        }

        if(activityStatus != 1) {
            isActive = false;
        }

        return isActive;
    }

    public boolean isUserActiveUsingUsername(String username) {
        String query = "SELECT is_active FROM `user` WHERE username = ?";
        int activityStatus;
        boolean isActive = true;

        try {
          activityStatus = jdbcTemplate.queryForObject(query, new Object[]{username}, Integer.class);
        } catch (Exception e) {
          activityStatus = 0;
        }

        if(activityStatus != 1) {
            isActive = false;
        }

        return isActive;
    }

    public String getUserActivityStatusByUserId(int userId) {
        String query = "SELECT is_active FROM `user` WHERE user_id = ?";
        int activityStatus;
        String activityStatusMessage = "active";

        try {
          activityStatus = jdbcTemplate.queryForObject(query, new Object[]{userId}, Integer.class);
        } catch (Exception e) {
          activityStatus = 0;
        }

        if(activityStatus != 1) {
            activityStatusMessage = "inactive";
        }

        return activityStatusMessage;
    }

    public String getUserActivityStatusByUsername(String username) {
        String query = "SELECT is_active FROM `user` WHERE username = ?";
        int activityStatus;
        String activityStatusMessage = "active";

        try {
          activityStatus = jdbcTemplate.queryForObject(query, new Object[]{username}, Integer.class);
        } catch (Exception e) {
          activityStatus = 0;
        }

        if(activityStatus != 1) {
            activityStatusMessage = "inactive";
        }

        return activityStatusMessage;
    }

    public User addNewUser(User user) {
        String query = "INSERT INTO `user` (username, email, forename, surname, born_at, is_active) VALUES (?, ?, ?, ?, ?, ?)";

        int insertStatus;
        User newUser = null;


        try {
          insertStatus = jdbcTemplate.update(query, user.getUsername(),
                                                    user.getEmail(),
                                                    user.getForename(),
                                                    user.getSurname(),
                                                    user.getBornAt(),
                                                    user.getIsActive());
        } catch (Exception e) {
          insertStatus = 0;
        }

        if(insertStatus == 1) {
          newUser = user;
        }

        return newUser;
    }

    public User updateUserById(int userId, User updatedUser) {
        String query = "UPDATE `user` " +
                       "SET username = ?, " +
                       "email = ?, " +
                       "forename = ?, " +
                       "surname = ?, " +
                       "born_at = ?, " +
                       "is_active = ? " +
                       "WHERE user_id = ?";

        int updateStatus;
        User user = null;

        try {
            updateStatus = jdbcTemplate.update(query, updatedUser.getUsername(),
                    updatedUser.getEmail(),
                    updatedUser.getForename(),
                    updatedUser.getSurname(),
                    updatedUser.getBornAt(),
                    updatedUser.getIsActive(),
                    userId);
        } catch (Exception e) {
            updateStatus = 0;
        }

        if(updateStatus == 1) {
          user = updatedUser;
        }

        return user;
    }

    public User updateUserByUsername(String username, User updatedUser) {
        String query = "UPDATE `user` " +
                "SET username = ?, " +
                "email = ?, " +
                "forename = ?, " +
                "surname = ?, " +
                "born_at = ?, " +
                "is_active = ? " +
                "WHERE username = ?";

        int updateStatus;
        User user = null;

        try {
            updateStatus =  jdbcTemplate.update(query, updatedUser.getUsername(),
                    updatedUser.getEmail(),
                    updatedUser.getForename(),
                    updatedUser.getSurname(),
                    updatedUser.getBornAt(),
                    updatedUser.getIsActive(),
                    username);
        } catch(Exception e) {
            updateStatus = 0;
        }

        if(updateStatus == 1) {
          user = updatedUser;
        }

        return user;
    }


    public boolean deleteUserByUserId(int userId) {
        String query = "DELETE FROM `user` WHERE user_id = ?";
        boolean isSuccessfullyDeleted = true;
        int deleteStatusCode;

        try {
          deleteStatusCode = jdbcTemplate.update(query, userId);
        } catch (Exception e) {
          deleteStatusCode = 0;
        }

        if(deleteStatusCode != 1) {
            isSuccessfullyDeleted = false;
        }

        return isSuccessfullyDeleted;
    }

    public boolean deleteUserByUsername(String username) {
        String query = "DELETE FROM `user` WHERE username = ?";
        boolean isSuccessfullyDeleted = true;
        int deleteStatusCode;

        try {
          deleteStatusCode = jdbcTemplate.update(query, username);
        } catch (Exception e) {
          deleteStatusCode = 0;
        }

        if(deleteStatusCode != 1) {
            isSuccessfullyDeleted = false;
        }
        return isSuccessfullyDeleted;
    }
}
