package ru.kata.spring.boot_security.demo.dao;




import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUserById(long id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    User getByUserName(String username);

}
