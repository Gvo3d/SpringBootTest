package projectpackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectpackage.repositories.DataRepository;

/**
 * Created by Gvozd on 30.12.2016.
 */
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataRepository dataRepository;

    public DataRepository getDataRepository() {
        return dataRepository;
    }

    public void setDataRepository(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }
}
