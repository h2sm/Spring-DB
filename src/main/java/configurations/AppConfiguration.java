package configurations;

import commands.Command;
import commands.Exit;
import commands.FindAchievements;
import commands.FindAll;
import logging.LoggingAspect;
import parse.Parser;
import parse.ParserImpl;
import console.Console;
import console.UI;
import database.DBFactory;
import database.DBInterface;
import localization.LocaleService;
import localization.MessageService;
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
@PropertySource("classpath:/dockerConfig.properties")
@EnableAspectJAutoProxy
public class AppConfiguration {
    @Autowired Environment env;
    @Bean
    public UI ui() {
        return new Console();
    }

    @Bean
    public DBInterface dbInterface() {
        return DBFactory.getInstance(properties());
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(ui(), dbInterface(), parse(), msgService());
    }
    @Bean
    public AuthProperties properties(){
        var properties = new AuthProperties();
        properties.setLogin(env.getProperty("docker.Login"));
        properties.setPassword(env.getProperty("docker.Password"));
        properties.setUrl(env.getProperty("docker.URL"));
        return properties;
    }
    @Bean
    public Parser parse(){
        var hs = new HashSet<Command>();
        hs.add(new Exit(dbInterface()));
        hs.add(new FindAll(dbInterface()));
        hs.add(new FindAchievements(dbInterface()));
        return new ParserImpl(hs);
    }
    @Bean
    public MessageSource messageSource(){
        var src = new ReloadableResourceBundleMessageSource();
        src.setBasename("classpath:languages");
        src.setDefaultEncoding("UTF-8");
        src.setCacheSeconds(900);
        src.setUseCodeAsDefaultMessage(true);
        return src;
    }
//    @Bean
//    public LoggingAspect aspect(){
//        return new LoggingAspect();
//    }
    @Bean
    public LocaleService localeService(){
        return new LocaleService(ui());
    }
    @Bean
    public MessageService msgService(){
        return new MessageService(messageSource(),localeService());
    }
}