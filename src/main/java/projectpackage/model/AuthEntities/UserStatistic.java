package projectpackage.model.AuthEntities;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Gvozd on 06.01.2017.
 */
@Entity
@Table(name = "USER_STATISTIC")
public class UserStatistic {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "US_ID")
    private long id;

    @Column(name = "US_CREATED")
    private Timestamp createdDate;

    @Column(name = "US_VIEWED_COUNT")
    private long viewedCount;

    @OneToOne(mappedBy = "userStatistic")
    private User user;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserStatistic that = (UserStatistic) o;

        if (getViewedCount() != that.getViewedCount()) return false;
        return getCreatedDate().equals(that.getCreatedDate());
    }

    @Override
    public int hashCode() {
        int result = getCreatedDate().hashCode();
        result = 31 * result + (int) (getViewedCount() ^ (getViewedCount() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "UserStatistic{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", viewedCount=" + viewedCount +
                '}';
    }
}