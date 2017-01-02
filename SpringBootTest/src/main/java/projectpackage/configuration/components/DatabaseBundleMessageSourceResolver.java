package projectpackage.configuration.components;

import org.springframework.context.support.AbstractMessageSource;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * Created by Gvozd on 02.01.2017.
 */
public class DatabaseBundleMessageSourceResolver extends AbstractMessageSource {
    @Override
    protected MessageFormat resolveCode(String s, Locale locale) {
        return null;
    }
}
