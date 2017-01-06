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
    private int id;

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
}
