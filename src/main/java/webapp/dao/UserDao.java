package webapp.dao;

import webapp.models.User;

import java.util.List;

public interface UserDao {

    void create(User user);

    List<User> getAllUsers();

    void update(User user);

    void delete(long id);

    User findUserById(long id);

    User findUserByLogin(String login);
}
