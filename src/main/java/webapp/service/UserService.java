package webapp.service;

import webapp.models.User;

import java.util.List;

public interface UserService {

    void create(User user);

    List<User> getAllUsers();

    void update(User user);

    void delete(long id);

    User findUserById(long id);

    User findUserByLogin(String login);
}
