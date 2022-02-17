package iconloop.myid.partner.adminpage.service;

import iconloop.myid.partner.adminpage.domain.entity.User;
import iconloop.myid.partner.adminpage.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

}
