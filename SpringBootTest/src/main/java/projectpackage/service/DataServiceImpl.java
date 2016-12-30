package projectpackage.service;

import org.springframework.stereotype.Service;
import projectpackage.repositories.DataRepository;

import javax.annotation.Resource;

/**
 * Created by Gvozd on 30.12.2016.
 */
@Service
public class DataServiceImpl implements DataService {

    @Resource
    DataRepository dataRepository;
}
