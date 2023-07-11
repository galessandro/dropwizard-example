package org.example.useridcard;

import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;


public class UserIdCardDAO extends AbstractDAO<UserIdCard> {

    @Inject
    public UserIdCardDAO(SessionFactory factory) {
        super(factory);
    }

    public UserIdCard findById(Long id){
        return get(id);
    }

    public Long create(UserIdCard userIdCard){
        return persist(userIdCard).getId();
    }

}