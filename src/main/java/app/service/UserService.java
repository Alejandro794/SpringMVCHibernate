package app.service;

import app.models.User;

import java.util.List;

public interface UserService {

    List<User> getUserS();

    User getUser(Long id);

    void createNewUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
