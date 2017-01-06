package projectpackage.model.AuthEntities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Gvozd on 06.01.2017.
 */
@Data
@Entity
@Table(name="USER_STATISTIC")
public class UserStatistic {

    @Id
    @Column(name="USER_STATISTIC_ID")
    private long fk_id;

    @Column(name = "US_CREATED")
    private Timestamp createdDate;

    @Column(name = "US_VIEWED_COUNT")
    private long viewedCount;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = User.class, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private User user;
}
