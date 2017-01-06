package projectpackage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projectpackage.model.Data;

/**
 * Created by Gvozd on 30.12.2016.
 */
@Repository
public interface DataRepository extends CrudRepository<Data, Long> {
}
