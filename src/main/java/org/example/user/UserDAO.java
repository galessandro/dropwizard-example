package org.example.user;

import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class UserDAO extends AbstractDAO<User> {

    @Inject
    public UserDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<User> findById(Long id){
        return Optional.ofNullable(get(id));
    }

    public Long create(User user){
        return persist(user).getId();
    }

    public List<User> findAll(){
        return list(query("SELECT p from User p"));
    }

    public boolean existsUserWithEmail(String email) {
        List<User> users = query("SELECT u FROM User u where u.email = :email")
                .setParameter("email", email)
                .getResultList();
        return users.size() > 0;
    }
}
