package org.example.useridcard;

import com.google.inject.Inject;

public class UserIdCardService {

    private final UserIdCardDAO userIdCardDAO;

    @Inject
    public UserIdCardService(UserIdCardDAO userIdCardDAO) {
        this.userIdCardDAO = userIdCardDAO;
    }

    public UserIdCard findById(Long id){
        return userIdCardDAO.findById(id);
    }

    public Long create(UserIdCard userIdCard){
        return userIdCardDAO.create(userIdCard);
    }
}
