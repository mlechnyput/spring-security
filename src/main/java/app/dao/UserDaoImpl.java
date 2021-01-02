package app.dao;

import org.springframework.stereotype.Repository;
import app.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public void create(User user) {
        em.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void delete(long id) {
        em.remove(findUserById(id));
    }

    @Override
    public User findUserById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public User findUserByLogin(String login) {
        TypedQuery<User>query= em.createQuery("from User u where u.login = :x", User.class);
        query.setParameter("x", login);
        return query.getSingleResult();
    }
}
