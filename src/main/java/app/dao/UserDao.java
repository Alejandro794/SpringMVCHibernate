package app.dao;

import app.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUserS();

    User getUser(Long id);

    void createNewUser(User user);

    void updateUser(Long id, User updateUser);

    void deleteUser(Long id);
}
