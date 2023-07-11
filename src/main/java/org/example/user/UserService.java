package org.example.user;

import com.google.inject.Inject;
import org.example.exception.DuplicateResourceException;
import org.example.exception.ResourceNotFoundException;

import java.util.List;

public class UserService {

    private final UserDAO userDAO;

    @Inject
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User findById(Long id){
        return userDAO.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "user with id [%s] not found".formatted(id)
                ));
    }

    public Long create(User user){
        if(userDAO.existsUserWithEmail(user.getEmail())){
            throw new DuplicateResourceException("email already taken");
        }

        return userDAO.create(user);
    }

    public List<User> findAll(){
        return userDAO.findAll();
    }
}
