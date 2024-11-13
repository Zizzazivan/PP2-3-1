package web.dao;

import web.models.User;

public interface UserDao {
    void insertUser(User user);
    User getUserByUsername(String username);
}
