package app.dao;

import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public UserDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Transactional
    @Override
    public List<User> getUserS() {
        EntityManager manager = entityManagerFactory.createEntityManager();
        return manager.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional
    @Override
    public User getUser(Long id) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        return manager.find(User.class, id);
    }

    @Transactional
    @Override
    public void createNewUser(User user) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.persist(user);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User newUser) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        User oldUser = manager.find(User.class, id);
        oldUser.setName(newUser.getName());
        oldUser.setSurname(newUser.getSurname());
        oldUser.setDate(newUser.getDate());
        oldUser.setEmail(newUser.getEmail());
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.remove(manager.find(User.class, id));
    }
}