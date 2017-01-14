package projectpackage.model.AuthEntities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Gvozd on 31.12.2016.
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "USER_ID")
    private long id;

    @Column(name = "FULL_NAME")
    private String fullname;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "PSWD")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "US_CREATED")
    private Timestamp createdDate;

    @Column(name = "US_VIEWED_COUNT")
    private long viewedCount;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "UR_USER_ID"), inverseJoinColumns = @JoinColumn(name = "UR_ROLE_ID"))
    private Set<Role> roles = new HashSet<>();

    @Column(name = "USER_ENABLED")
    private boolean enabled;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public long getViewedCount() {
        return viewedCount;
    }

    public void setViewedCount(long viewedCount) {
        this.viewedCount = viewedCount;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getViewedCount() != user.getViewedCount()) return false;
        if (!getFullname().equals(user.getFullname())) return false;
        if (!getUsername().equals(user.getUsername())) return false;
        return getCreatedDate() != null ? getCreatedDate().equals(user.getCreatedDate()) : user.getCreatedDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getFullname().hashCode();
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + (getCreatedDate() != null ? getCreatedDate().hashCode() : 0);
        result = 31 * result + (int) (getViewedCount() ^ (getViewedCount() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", createdDate=" + createdDate +
                ", viewedCount=" + viewedCount +
                ", roles=" + roles +
                ", enabled=" + enabled +
                '}';
    }
}