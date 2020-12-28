package webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webapp.dao.RoleDaoImpl;
import webapp.dao.UserDao;
import webapp.models.Role;
import webapp.models.User;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private RoleDaoImpl roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDaoImpl roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public void create(User user) {
        Set<Role> set = new HashSet<>();
        Role role1 = roleDao.findByRole("USER");
        set.add(role1);

//        Role role2 = roleDao.findByRole("ADMIN");
//        set.add(role2);

        user.setRoles(set);
        userDao.create(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void update(User user) {
        User old = userDao.findUserById(user.getId());
//        old.setLogin(user.getLogin());
//        old.setPassword(user.getPassword());
        user.setRoles(old.getRoles());
        userDao.update(user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public User findUserById(long id) {
        return userDao.findUserById(id);
    }

    @Transactional
    @Override
    public User findUserByLogin(String login) {
        return userDao.findUserByLogin(login);
    }
}
