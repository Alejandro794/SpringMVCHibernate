package app.dao;

import app.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<User> getUserS() {
        return manager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUser(Long id) {
        return manager.find(User.class, id);
    }

    @Override
    public void createNewUser(User user) {
        manager.persist(user);
    }

    @Override
    public void updateUser(Long id, User newUser) {
        User oldUser = manager.find(User.class, id);
        oldUser.setName(newUser.getName());
        oldUser.setSurname(newUser.getSurname());
        oldUser.setDate(newUser.getDate());
        oldUser.setEmail(newUser.getEmail());
    }

    @Override
    public void deleteUser(Long id) {
        manager.remove(manager.find(User.class, id));
    }
}