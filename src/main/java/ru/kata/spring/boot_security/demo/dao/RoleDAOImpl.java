package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select '*' from Role", Role.class).getResultList();
    }

    @Override
    public Role findById(int id) {
        return entityManager.createQuery("select '*' from Role where id = :id", Role.class)
                .setParameter("id",id).getSingleResult();
    }

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);

    }

    @Override
    public Role getByName(String name) {
        return entityManager.createQuery("select '*' from Role where name = :name", Role.class)
                .setParameter("name", name).getSingleResult();
    }
}
