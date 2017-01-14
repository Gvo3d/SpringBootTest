package tests.database;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import projectpackage.model.AuthEntities.Role;
import projectpackage.model.AuthEntities.User;
import projectpackage.repositories.AuthRepositories.RolesRepository;
import projectpackage.repositories.InternationalizationRepositories.InterMessageRepository;
import projectpackage.service.UserService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gvozd on 06.01.2017.
 */
@Transactional
public class RepositoryTests extends AbstractDatabaseTest {

    @Autowired
    UserService userService;

    @Autowired
    InterMessageRepository interMessageRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Test
    @Rollback(true)
    public void getUser(){
        System.out.println(userService.toString());
        System.out.println("****************************************************************");
        System.out.println(userService.findOne(2L).toString());
        System.out.println("****************************************************************");
    }

    @Test
    @Rollback(true)
    public void getUserByLogin(){
        System.out.println(userService.toString());
        System.out.println("****************************************************************");
        User user = userService.findByUsername("qwerty");
        System.out.println(user.toString());
        System.out.println("****************************************************************");
    }

    @Test
    @Rollback(true)
    public void createUser(){
        System.out.println(userService.toString());
        System.out.println("****************************************************************");
        User user = new User();
        user.setFullname("QuackUser");
        user.setUsername("quack");
        user.setPassword("quack");
        user.setEnabled(true);
        Role role = rolesRepository.findOne(2);
        Set<Role> newRolesSet = new HashSet<Role>();
        newRolesSet.add(role);
        user.setRoles(newRolesSet);
        userService.save(user);
        System.out.println(user);
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