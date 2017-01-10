package projectpackage.service;

import projectpackage.model.AuthEntities.User;

/**
 * Created by Gvozd on 07.01.2017.
 */
public interface UserService {
    void save(User user);
    User findByLogin(String login);
}
