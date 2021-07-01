package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.models.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

}
