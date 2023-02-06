package com.fci.advanced.se.personsmanagement.User;
import com.fci.advanced.se.personsmanagement.User.CurrentUser;
import com.fci.advanced.se.personsmanagement.User.Response;
import com.fci.advanced.se.personsmanagement.User.User;
import com.fci.advanced.se.personsmanagement.User.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/AuthenticationController")
public class AuthenticationController {
    @Autowired
    UserEntity userEntity = new UserEntity();
    @PostMapping("/add")
    // signUp
    public Response signUp(@RequestBody User p) {
        System.out.println("in add person" + p);
        boolean res = userEntity.addUser(p);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("User Already Exists");
            return response;
        }
        response.setStatus(true);
        response.setMessage("User signed up successfully");
        return response;
    }
    // Login
    @GetMapping("/get/{userName}/{password}")
    public Response<User> login(@PathVariable("userName") String userName, @PathVariable("password") String password) {

        var user = userEntity.getUser(userName, password);
        Response<User> response = new Response<User>();
        if (user == null) {
            response.setStatus(false);
            response.setMessage("User Not Found, create new account");
            response.object = null;
            return response;
        }

        CurrentUser.user = user;
        response.setStatus(true);
        response.setMessage("User login Successfully");
        response.object =  CurrentUser.user;
        return response;
    }
}
