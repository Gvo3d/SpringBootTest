package projectpackage.repositories.AuthRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projectpackage.model.AuthEntities.Roles;

/**
 * Created by Gvozd on 06.01.2017.
 */
@Repository
public interface RolesRepository extends CrudRepository<Roles, Integer>{
}
