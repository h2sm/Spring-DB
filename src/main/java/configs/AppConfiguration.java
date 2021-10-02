package configs;

import crossFunctionality.localization.LocaleService;
import crossFunctionality.localization.MessageService;
import org.springframework.stereotype.Component;
import services.commands.Command;
import services.commands.Exit;
import services.commands.FindAchievements;
import services.commands.FindAll;
import crossFunctionality.logging.LoggingAspect;
import services.parser.Parser;
import services.parser.ParserImpl;
import services.consoleIO.ConsoleUI;
import services.consoleIO.UI;
import services.database.DBFactory;
import services.database.DBInterface;
import userInteraction.EntryService;
import userInteraction.EntryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;

import java.util.HashSet;

@Configuration
@Component
@PropertySource("classpath:/dockerConfig.properties")
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class AppConfiguration {
    @Autowired
    Environment env;

    @Bean//userInterface bean: responsible for input and output of information
    public UI ui() {
        return new ConsoleUI(msgService());
    }

    @Bean//Interface of database to properly interfere with it
    public DBInterface dbInterface() {
        return DBFactory.getInstance(properties());
    }

    @Bean//this service interacts with user: takes commands and starts them
    public EntryService userService() {
        return new EntryServiceImpl(ui(), parse(), msgService());
    }

    @Bean//bean for auth properties for postgres login, pass and url (postgres is running in docker)
    public AuthProperties properties() {
        var properties = new AuthProperties();
        properties.setLogin(env.getProperty("docker.Login"));
        properties.setPassword(env.getProperty("docker.Password"));
        properties.setUrl(env.getProperty("docker.URL"));
        return properties;
    }

    @Bean//this parser parses commands from user.
    public Parser parse() {
        var hs = new HashSet<Command>();
        hs.add(new Exit(dbInterface()));
        hs.add(new FindAll(dbInterface()));
        hs.add(new FindAchievements(dbInterface()));
        return new ParserImpl(hs);
    }

    @Bean//this bean is responsible for language tag setter and getter
    public LocaleService localeService() {
        return new LocaleService();
    }

    @Bean
    public MessageService msgService() {//this bean encapsulates localeservice (basically a Locale Tag) and messagesourse(takes all the texts for different languages)
        return new MessageService(messageSource(), localeService());
    }

    @Bean//message source for taking localization packs in "resources" folder
    public MessageSource messageSource() {
        var src = new ReloadableResourceBundleMessageSource();
        src.setBasename("classpath:languages");
        src.setDefaultEncoding("UTF-8");
        src.setCacheSeconds(900);
        src.setUseCodeAsDefaultMessage(true);
        return src;
    }

    @Bean//self-made logging bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}