package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    //create
    //save
    void addUser(User user);

    //read
    List<User> getUsers();

    //update
    void updateUser(int id, User user);

    //delete
    void deleteUser(int id);

    //getUser
    User getUserById(int id);

}
