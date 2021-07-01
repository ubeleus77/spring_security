package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDAO userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.getUser(s).getUserDetails();
    }
}
