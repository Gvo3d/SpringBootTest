package projectpackage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Gvozd on 30.12.2016.
 */
public interface DataRepository<T, ID extends Serializable> extends JpaRepository {
}
