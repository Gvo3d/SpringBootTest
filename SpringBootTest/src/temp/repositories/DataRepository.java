package projectpackage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projectpackage.model.Data;

/**
 * Created by Gvozd on 30.12.2016.
 */
public interface DataRepository extends JpaRepository<Data, Long> {
}
