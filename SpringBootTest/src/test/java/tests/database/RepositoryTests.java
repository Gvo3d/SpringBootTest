package tests.database;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import projectpackage.repositories.AuthRepositories.UserRepository;
import tests.AbstractTest;

/**
 * Created by Gvozd on 06.01.2017.
 */
@Transactional
public class RepositoryTests extends AbstractTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void getUser(){
        System.out.println(userRepository.findOne(2L));
    }
}
