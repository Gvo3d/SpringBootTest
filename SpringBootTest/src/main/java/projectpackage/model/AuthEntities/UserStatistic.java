package projectpackage.model.AuthEntities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Gvozd on 06.01.2017.
 */
@Entity
@IdClass(User.class)
@Table(name="USER_STATISTIC")
public class UserStatistic {

    @Id
    @Column(name="USER_STATISTIC_ID")
    private long fk_id;

    @Column(name = "US_CREATED")
    private Timestamp createdDate;

    @Column(name = "US_VIEWED_COUNT")
    private long viewedCount;


    @Id
    @OneToOne
    @JoinColumn(name="USER_STATISTIC_ID", referencedColumnName = "USER_ID")
    private User user;

    public long getFk_id() {
        return fk_id;
    }

    public void setFk_id(long fk_id) {
        this.fk_id = fk_id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserStatistic{" +
                "fk_id=" + fk_id +
                ", createdDate=" + createdDate +
                ", viewedCount=" + viewedCount +
                '}';
    }
}
