package projectpackage.components;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

@Component
public class VerticalDatabaseMessageSource extends AbstractDatabaseMessageSource {

    private static final String I18N_QUERY = "select IM_CODE, IM_LOCALE, IM_DATA from INTERNATIONAL_MESSAGES";

    @Override
    protected String getI18NSqlQuery() {
        return I18N_QUERY;
    }

    @Override
    protected Messages extractI18NData(ResultSet rs) throws SQLException, DataAccessException {

        Messages messages = new Messages();
        while (rs.next()) {
            Locale locale = new Locale(rs.getString("IM_LOCALE"));
            messages.addMessage(rs.getString("IM_CODE"), locale, rs.getString("IM_DATA"));
        }
        return messages;
    }
}