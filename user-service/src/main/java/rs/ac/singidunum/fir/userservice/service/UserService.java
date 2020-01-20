package rs.ac.singidunum.fir.userservice.service;

import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.userservice.dao.UserDao;
import rs.ac.singidunum.fir.userservice.model.User;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public int getUsersCount() {
        return userDao.getUsersCount();
    }

    public boolean isUserActiveUsingUserId(int userId) {
        return userDao.isUserActiveUsingUserId(userId);
    }

    public boolean isUserActiveUsingUsername(String username) {
        return userDao.isUserActiveUsingUsername(username);
    }

    public String getUserActivityStatusByUserId(int userId) {
        return userDao.getUserActivityStatusByUserId(userId);
    }

    public String getUserActivityStatusByUsername(String username) {
        return userDao.getUserActivityStatusByUsername(username);
    }

    public User addNewUser(User user) {
        return userDao.addNewUser(user);
    }

    
    public User updateUserById(int userId, User updatedUser) {
        return userDao.updateUserById(userId, updatedUser);
    }

    public User updateUserByUsername(String username, User updatedUser) {
        return userDao.updateUserByUsername(username, updatedUser);
    }

    public boolean deleteUserByUserId(int userId) {
        return userDao.deleteUserByUserId(userId);
    }

    public boolean deleteUserByUsername(String username) {
        return userDao.deleteUserByUsername(username);
    }
}
