package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;
import web.models.Role;


public interface RoleDao {
   Role getById(Long id);
}
