package projectpackage.model.Internationalization;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Gvozd on 06.01.2017.
 */
@Data
@Entity
@Table(name = "INTERNATIONAL_MESSAGES")
public class InterMessage {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "INTERNATIONAL_MESSAGES_ID")
    private Integer id;

    @Column(name = "IM_CODE")
    private String code;

    @Column(name = "IM_LOCALE")
    private String stringLocale;

    @Column(name = "IM_DATA")
    private String message;

    @Override
    public String toString() {
        return "InterMessage{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", stringLocale='" + stringLocale + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterMessage that = (InterMessage) o;

        if (!code.equals(that.code)) return false;
        if (!stringLocale.equals(that.stringLocale)) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + stringLocale.hashCode();
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
