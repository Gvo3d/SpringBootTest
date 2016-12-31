package projectpackage.model.AuthEntities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by Gvozd on 31.12.2016.
 */
@Entity
@Table(name="users")
public class User {
    private long id;
    private String username;
    private String login;
    private AuthorizationCredentials authorizationCredentials;
    private Set<Roles> roles;
    private Timestamp createdDate;
    private boolean enabled;
}
