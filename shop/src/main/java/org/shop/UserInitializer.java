package org.shop;

import org.shop.api.UserService;
import org.shop.data.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The User Initializer util class.
 */
public class UserInitializer {

    /** The user service. */
    @Autowired
    private UserService userService;

    /**
     * Instantiates a new user initializer.
     *
     * @param userService the user service
     */
    public UserInitializer(UserService userService) {
        super();
        this.userService = userService;
    }
    
    /**
     * Inits the users.
     */
    public void initUsers() {
        User user = null;
        
        user = new User();
        user.setUsername("Ivan Ivanov");
        userService.registerUser(user);
        
        user = new User();
        user.setUsername("Petr Petrov");
        userService.registerUser(user);
    }
}
