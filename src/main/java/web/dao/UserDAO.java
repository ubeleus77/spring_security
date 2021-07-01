package web.dao;

import org.springframework.data.jpa.repository.Query;
import web.models.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    List<User> getAllUsers();

     void removeUserById(Long id);

    User getUserById(long id);

    void updateUser(User user);


    User getUser(String s);
}
