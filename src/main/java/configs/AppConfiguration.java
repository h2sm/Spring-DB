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
import logics.UserService;
import logics.UserServiceImpl;
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
        return new ConsoleUI();
    }

    @Bean//Interface of database to properly interfere with it
    public DBInterface dbInterface() {
        return DBFactory.getInstance(properties());
    }

    @Bean//
    public UserService userService() {
        return new UserServiceImpl(ui(), parse());
        //return new UserServiceImpl(ui(), parse(), msgService());
    }

    @Bean//bean of auth properties for postgres login, pass and url (postgres is in docker)
    public AuthProperties properties() {
        var properties = new AuthProperties();
        properties.setLogin(env.getProperty("docker.Login"));
        properties.setPassword(env.getProperty("docker.Password"));
        properties.setUrl(env.getProperty("docker.URL"));
        return properties;
    }

    @Bean//this parser parses commands from user
    public Parser parse() {
        var hs = new HashSet<Command>();
        hs.add(new Exit(dbInterface()));
        hs.add(new FindAll(dbInterface()));
        hs.add(new FindAchievements(dbInterface()));
        return new ParserImpl(hs);
    }

    @Bean//message source for i18n
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

    @Bean//this bean is responsible for language tagging
    public LocaleService localeService() {
        return new LocaleService(ui());
    }

    @Bean
    public MessageService msgService() {
        return new MessageService(messageSource(), localeService());
    }
}