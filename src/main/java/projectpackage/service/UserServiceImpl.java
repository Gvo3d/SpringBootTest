package projectpackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import projectpackage.model.AuthEntities.User;
import projectpackage.repositories.AuthRepositories.RolesRepository;
import projectpackage.repositories.AuthRepositories.UserRepository;

import javax.transaction.Transactional;
import java.sql.Timestamp;

/**
 * Created by Gvozd on 07.01.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (user.getFullname()==null || user.getFullname().equals("")){
            StringBuilder sb = new StringBuilder();
            String firstChar = user.getUsername().substring(0,1);
            sb.append(firstChar.toUpperCase());
            sb.append(user.getUsername().substring(1,user.getUsername().length()));
            user.setFullname(sb.toString());
        } else {
            user.setFullname(user.getFullname().trim());
        }
        user.setViewedCount(0);
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
    }

    @Transactional
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findOne(Long id) {
        return userRepository.findOne(id);
    }
}
