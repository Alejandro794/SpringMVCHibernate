package app.dao;

import app.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager manager;

    @Transactional(readOnly = true)
    @Override
    public List<User> getUserS() {
        return manager.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(Long id) {
        return manager.find(User.class, id);
    }

    @Transactional
    @Override
    public void createNewUser(User user) {
        manager.persist(user);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User newUser) {
        User oldUser = manager.find(User.class, id);
        oldUser.setName(newUser.getName());
        oldUser.setSurname(newUser.getSurname());
        oldUser.setDate(newUser.getDate());
        oldUser.setEmail(newUser.getEmail());
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        manager.remove(manager.find(User.class, id));
    }
}