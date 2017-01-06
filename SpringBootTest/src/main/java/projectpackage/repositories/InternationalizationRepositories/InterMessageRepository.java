package projectpackage.repositories.InternationalizationRepositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projectpackage.model.Internationalization.InterMessage;

/**
 * Created by Gvozd on 06.01.2017.
 */
@Repository
public interface InterMessageRepository extends CrudRepository<InterMessage, Integer>{
}
