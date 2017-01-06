package tests.database;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import projectpackage.repositories.AuthRepositories.UserRepository;
import projectpackage.repositories.InternationalizationRepositories.InterMessageRepository;

/**
 * Created by Gvozd on 06.01.2017.
 */
@Transactional
public class RepositoryTests extends AbstractDatabaseTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    InterMessageRepository interMessageRepository;

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
    public void getMessage(){
        System.out.println(interMessageRepository.toString());
        System.out.println("****************************************************************");
        System.out.println(interMessageRepository.findOne(1).toString());
        System.out.println("****************************************************************");

    }
}
