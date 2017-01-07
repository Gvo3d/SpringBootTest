package projectpackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import projectpackage.model.AuthEntities.Role;
import projectpackage.model.AuthEntities.User;
import projectpackage.model.AuthEntities.UserStatistic;
import projectpackage.repositories.AuthRepositories.RolesRepository;
import projectpackage.repositories.AuthRepositories.UserRepository;
import projectpackage.repositories.AuthRepositories.UserStatisticRepository;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gvozd on 07.01.2017.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private UserStatisticRepository userStatisticRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(rolesRepository.findOne(1));
        user.setRoles(roleSet);
        UserStatistic userStatistic = new UserStatistic();
        userStatistic.setViewedCount(0);
        userStatistic.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        user.setUserStatistic(userStatistic);
        userRepository.save(user);
        userStatistic.setUser(user);
        userStatisticRepository.save(userStatistic);
    }

    @Override
    public User findByUsername() {
        return null;
    }
}
