package rs.ac.singidunum.fir.userservice.controller;

import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.fir.userservice.model.User;
import rs.ac.singidunum.fir.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 1. http://localhost:8080/users
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 2. http://localhost:8080/users/id/{userId}
    @RequestMapping(method = RequestMethod.GET, path = "/id/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    // 3. http://localhost:8080/users/username/{username}
    @RequestMapping(method = RequestMethod.GET, path = "/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    // 4. http://localhost:8080/users/count
    @RequestMapping(method = RequestMethod.GET, path = "/count")
    public int getUsersCount() {
        return userService.getUsersCount();
    }

    // 5. http://localhost:8080/users/is-active/id/{userId}
    @RequestMapping(method = RequestMethod.GET, path = "/is-active/id/{userId}")
    public boolean isUserActiveUsingUserId(@PathVariable int userId) {
        return userService.isUserActiveUsingUserId(userId);
    }

    // 6. http://localhost:8080/users/is-active/username/{username}
    @RequestMapping(method = RequestMethod.GET, path = "/is-active/username/{username}")
    public boolean isUserActiveUsingUsername(@PathVariable String username) {
        return userService.isUserActiveUsingUsername(username);
    }

    // 7. http://localhost:8080/users/activity-status/id/{userId}
    @RequestMapping(method = RequestMethod.GET, path = "/activity-status/id/{userId}")
    public String getUserActivityStatusByUserId(@PathVariable int userId) {
        return userService.getUserActivityStatusByUserId(userId);
    }

    // 8. http://localhost:8080/users/activity-status/username/{username}
    @RequestMapping(method = RequestMethod.GET, path = "/activity-status/username/{username}")
    public String getUserActivityStatusByUsername(@PathVariable String username) {
        return userService.getUserActivityStatusByUsername(username);
    }

    // 9. http://localhost:8080/users
    @RequestMapping(method = RequestMethod.POST)
    public User addNewUser(@RequestBody User newUser) {
        return userService.addNewUser(newUser);
    }

    // 10. http://localhost:8080/users/id/{userId}
    @RequestMapping(method = RequestMethod.PUT, path = "/id/{userId}")
    public User updateUserById(@PathVariable int userId, @RequestBody User updatedUser) {
        return userService.updateUserById(userId, updatedUser);
    }

    // 11. http://localhost:8080/users/username/{username}
    @RequestMapping(method = RequestMethod.PUT, path = "/username/{username}")
    public User updateUserByUsername(@PathVariable String username, @RequestBody User updatedUser) {
        return userService.updateUserByUsername(username, updatedUser);
    }

    // 12. http://localhost:8080/users/id/{userId}
    @RequestMapping(method = RequestMethod.DELETE, path="/id/{userId}")
    public boolean deleteUserByUserId(@PathVariable int userId) {
        return userService.deleteUserByUserId(userId);
    }

    // 13. http://localhost:8080/users/username/{username}
    @RequestMapping(method = RequestMethod.DELETE, path = "/username/{username}")
    public boolean deleteUserByUsername(@PathVariable String username) {
        return userService.deleteUserByUsername(username);
    }

}
