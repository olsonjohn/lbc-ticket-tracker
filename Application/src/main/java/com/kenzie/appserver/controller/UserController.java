package com.kenzie.appserver.controller;

import com.kenzie.appserver.controller.model.UserCreateRequest;
import com.kenzie.appserver.controller.model.UserResponse;
import com.kenzie.appserver.controller.model.UserUpdateRequest;
import com.kenzie.appserver.service.UserService;
import com.kenzie.appserver.service.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;



@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     *
     * @param userCreateRequest
     * @return URL with the user that was created.
     */
    @PostMapping
    public ResponseEntity<UserResponse> addNewUser(@RequestBody UserCreateRequest userCreateRequest) {
        User user = new User(userCreateRequest);
        userService.addNewUser(user);

        UserResponse userResponse = new UserResponse(user);

        return ResponseEntity.created(URI.create("/user/" + userResponse.getUserId())).body(userResponse);
    }

    /**
     * Get a User
     * @param id
     * @return user data
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable("id") String id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        UserResponse userResponse = new UserResponse(user);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<User> userList = userService.findAll();

        if(userList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List<UserResponse> responses = new ArrayList<>();
        for( User user: userList){
            responses.add(new UserResponse(user));
        }
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("id")String userId, @RequestBody UserUpdateRequest userUpdateRequest) {
        User user = new User(userUpdateRequest);
        User updatedUser = userService.updateUser(userId, user);
        UserResponse userResponse = new UserResponse(updatedUser);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id")String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
}
