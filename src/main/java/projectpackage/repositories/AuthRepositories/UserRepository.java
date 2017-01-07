package projectpackage.repositories.AuthRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projectpackage.model.AuthEntities.User;

/**
 * Created by Gvozd on 06.01.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
