package com.hds.ssm.service.user;



import com.hds.ssm.model.User;
import com.hds.ssm.model.UserRole;

import java.util.List;

public interface UserService {

    List<User> selectUsers();
    User findUser(String name);
    User findUserById(Integer id);
    int addUser(User user);
    UserRole getUserTypeById(Integer id);
    void changePassWord(Integer id, String password);
}
