package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> getAllRoles();
    Role findById(int id);
    void saveRole(Role role);
    Role getByName(String name);

}
