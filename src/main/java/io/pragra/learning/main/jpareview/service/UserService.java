package io.pragra.learning.main.jpareview.server;

import io.pragra.learning.main.jpareview.entity.User;
import io.pragra.learning.main.jpareview.exceptions.BadUserArgumentException;
import io.pragra.learning.main.jpareview.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public User createUser(User user){
        if(user.getFirstName()== null){
            throw new BadUserArgumentException("First Name Cant be Null");
        }
    }
}
