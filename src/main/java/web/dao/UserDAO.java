package web.dao;

import org.springframework.data.jpa.repository.Query;
import web.models.Role;
import web.models.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    List<User> getAllUsers();

     void removeUserById(Long id);

    User getUserById(Long id);

    void updateUser(User user);

    User getUserByName(String s);
}
