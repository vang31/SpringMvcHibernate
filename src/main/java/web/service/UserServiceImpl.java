package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

//    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

//    @Transactional
    @Override
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }

//    @Transactional
    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

//    @Transactional
    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

//    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }


}
