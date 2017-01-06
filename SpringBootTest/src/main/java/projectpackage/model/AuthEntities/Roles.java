package projectpackage.model.AuthEntities;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Gvozd on 31.12.2016.
 */
@Data
@Entity
@Table(name="ROLES")
public class Roles {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ROLE_ID")
    private int id;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roles roles = (Roles) o;

        if (id != roles.id) return false;
        return roleName.equals(roles.roleName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + roleName.hashCode();
        return result;
    }
}
