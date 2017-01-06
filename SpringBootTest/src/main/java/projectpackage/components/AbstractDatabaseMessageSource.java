package projectpackage.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import projectpackage.model.Internationalization.InterMessage;
import projectpackage.repositories.InternationalizationRepositories.InterMessageRepository;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class AbstractDatabaseMessageSource extends AbstractMessageSource {
    private Messages messages;
    private String defaultLocale;
    @Autowired
    private InterMessageRepository interMessageRepository;

    public String getDefaultLocale() {
        return defaultLocale;
    }

    public void setDefaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        String msg = messages.getMessage(code, locale);
        return createMessageFormat(msg, locale);
    }

    @PostConstruct
    public void init() {
        messages = new Messages();
        for (InterMessage im : interMessageRepository.findAll()) {
            System.out.println(im.toString());
            String code = im.getCode();
            String stringLocale = im.getStringLocale();
            messages.addMessage(code, new Locale.Builder().setLanguage(stringLocale).setRegion(stringLocale.toUpperCase()).build(), im.getMessage());
        }
        if (defaultLocale != null) {
            messages.setDefaultLocale(defaultLocale);
        }
        System.out.println(messages.toString());
    }

    protected static final class Messages {
        private Map<String, Map<Locale, String>> messagesData;
        private String defaultLocale;

        public void setDefaultLocale(String defaultLocale) {
            this.defaultLocale = defaultLocale;
        }

        /* <code, <locale, message>> */
        public void addMessage(String code, Locale locale, String msg) {
            if (messagesData == null) {
                messagesData = new HashMap<String, Map<Locale, String>>();
                System.out.println("Creating messagesData");
            }

            Map<Locale, String> data = messagesData.get(code);
            if (data == null) {
                System.out.println("Data for message '"+code+"' is null");
                data = new HashMap<Locale, String>();
                messagesData.put(code, data);
            }
            System.out.println("Putting data for this message: locale="+locale+" message="+msg);
            data.put(locale, msg);
        }

        public String getMessage(String code, Locale locale) {
            Map<Locale, String> data = messagesData.get(code);
            for (Map.Entry entry:data.entrySet()){
                System.out.println("Entry key="+entry.getKey()+ " value="+entry.getValue());
            }
            String result = data != null ? data.get(locale) : data.get(new Locale.Builder().setLanguage(defaultLocale).setRegion(defaultLocale.toUpperCase()).build());
            return result;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry:messagesData.entrySet()){
                sb.append("Entry for "+entry.getKey()+" is:");
                Map<Locale, String> innerMap = (Map) entry.getValue();
                for (Map.Entry entry2:innerMap.entrySet()){
                    sb.append("Inner entry: key="+entry2.getKey()+" value="+entry2.getValue());
                }
            }
            return sb.toString();
        }
    }
}
