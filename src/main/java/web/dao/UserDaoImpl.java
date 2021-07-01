package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.models.Role;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();

    }

    @Override
    @Transactional
    public void removeUserById(Long id) {
        entityManager.createQuery("delete from User u where u.id = : id")
                .setParameter("id", id).executeUpdate();
        entityManager.close();
    }

    @Override
    public User getUserById(long id) {
        TypedQuery<User> userTypedQuery = entityManager.createQuery("select  u from User u where u.id = : id", User.class);
        userTypedQuery.setParameter("id", id);
        entityManager.close();
        return userTypedQuery.getResultList().stream().findAny().orElse(null);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.close();
    }

    @Override
    public User getUser(String s) {
        return entityManager.find(User.class, s);
    }

    public void newRole (Long id){

        Role roleAdmin = entityManager.find(Role.class, 1);
        User user1 = getUserById(id);
        user1.addRole(roleAdmin);

    }
    public void deleteRole(Long id){
        User user = getUserById(id);
        user.removeRole(2L);
    }
}
