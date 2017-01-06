package projectpackage.model.AuthEntities;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Gvozd on 31.12.2016.
 */
@Data
@Entity
@Table(name="USERS")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "USER_ID")
    private long id;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PSWD")
    private String password;

//    @OneToOne
//    private UserStatistic userStatistic;

//    private AuthorizationCredentials authorizationCredentials;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "UR_USER_ID"), inverseJoinColumns = @JoinColumn(name = "UR_ROLE_ID"))
//    private Set<Roles> roles = new HashSet<>();

    @Column(name = "USER_ENABLED")
    private boolean enabled;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (isEnabled() != user.isEnabled()) return false;
        if (!getUsername().equals(user.getUsername())) return false;
        if (!getLogin().equals(user.getLogin())) return false;
        return getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        int result = getUsername().hashCode();
        result = 31 * result + getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (isEnabled() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
//                ", userStatistic=" + userStatistic +
//                ", roles=" + roles +
                ", enabled=" + enabled +
                '}';
    }
}
