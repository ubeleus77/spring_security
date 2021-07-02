package web.dao;

import org.springframework.stereotype.Component;
import web.models.Role;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Component
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getById(Long id) {
        TypedQuery<Role> userTypedQuery = entityManager.createQuery("select  u from Role u where u.id = : id", Role.class);
        userTypedQuery.setParameter("id", id);

        return userTypedQuery.getResultList().stream().findAny().orElse(null);
    }
}
