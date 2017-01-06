package tests.database;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import projectpackage.model.AuthEntities.Role;
import projectpackage.model.AuthEntities.User;
import projectpackage.model.AuthEntities.UserStatistic;
import projectpackage.repositories.AuthRepositories.RolesRepository;
import projectpackage.repositories.AuthRepositories.UserRepository;
import projectpackage.repositories.AuthRepositories.UserStatisticRepository;
import projectpackage.repositories.InternationalizationRepositories.InterMessageRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gvozd on 06.01.2017.
 */
@Transactional
public class RepositoryTests extends AbstractDatabaseTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    InterMessageRepository interMessageRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    UserStatisticRepository userStatisticRepository;

    @Test
    @Rollback(true)
    public void getUser(){
        System.out.println(userRepository.toString());
        System.out.println("****************************************************************");
        System.out.println(userRepository.findOne(2L).toString());
        System.out.println("****************************************************************");

    }

    @Test
    @Rollback(true)
    public void createUser(){
        System.out.println(userRepository.toString());
        System.out.println("****************************************************************");
        User user = new User();
        user.setUsername("QuackUser");
        user.setLogin("quack");
        user.setPassword("quack");
        user.setEnabled(true);

        Role role = rolesRepository.findOne(2);
        Set<Role> newRolesSet = new HashSet<Role>();
        newRolesSet.add(role);
        user.setRoles(newRolesSet);

        UserStatistic userStatistic = new UserStatistic();
        user.setUserStatistic(userStatistic);
        System.out.println(userRepository.save(user));

        userStatistic.setUser(user);
        System.out.println(userStatisticRepository.save(userStatistic));
        System.out.println("****************************************************************");

    }

    @Test
    @Rollback(true)
    public void getMessage(){
        System.out.println(interMessageRepository.toString());
        System.out.println("****************************************************************");
        System.out.println(interMessageRepository.findOne(1).toString());
        System.out.println("****************************************************************");

    }
}
