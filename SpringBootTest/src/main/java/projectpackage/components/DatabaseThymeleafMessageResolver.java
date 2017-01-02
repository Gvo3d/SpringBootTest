package projectpackage.components;

import org.thymeleaf.Arguments;
import org.thymeleaf.messageresolver.IMessageResolver;
import org.thymeleaf.messageresolver.MessageResolution;

/**
 * Created by Gvozd on 02.01.2017.
 */
public class DatabaseThymeleafMessageResolver implements IMessageResolver {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Integer getOrder() {
        return null;
    }

    @Override
    public MessageResolution resolveMessage(Arguments arguments, String s, Object[] objects) {
        return null;
    }

    @Override
    public void initialize() {

    }
}
