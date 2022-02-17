package iconloop.myid.partner.adminpage.controller;

import iconloop.myid.partner.adminpage.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

}
