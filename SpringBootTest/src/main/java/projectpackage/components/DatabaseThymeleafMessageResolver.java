package projectpackage.components;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.NoSuchMessageException;
import org.thymeleaf.Arguments;
import org.thymeleaf.messageresolver.AbstractMessageResolver;
import org.thymeleaf.messageresolver.MessageResolution;
import org.thymeleaf.util.Validate;

/**
 * Created by Gvozd on 02.01.2017.
 */

public final class DatabaseThymeleafMessageResolver extends AbstractMessageResolver implements MessageSourceAware {
    MessageSource messageSource;

    public DatabaseThymeleafMessageResolver() {
    }

    public DatabaseThymeleafMessageResolver(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public MessageResolution resolveMessage(Arguments arguments, String s, Object[] objects) {
        Validate.notNull(arguments, "Arguments cannot be null");
        Validate.notNull(arguments.getContext().getLocale(), "Locale in context cannot be null");
        Validate.notNull(s, "Message key cannot be null");
        try {
            String e = this.messageSource.getMessage(s, objects, arguments.getContext().getLocale());
            System.out.println(e.toString());
            return new MessageResolution(e);
        } catch (NoSuchMessageException var5) {
            return null;
        }
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

}
