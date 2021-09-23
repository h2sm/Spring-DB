package configuration;

import commands.parsing.Parser;
import commands.parsing.ParserImpl;
import console.Console;
import console.UI;
import database.DBFactory;
import database.DBInterface;
import logics.UserService;
import logics.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/dockerConfig.properties")
public class AppConfiguration {
    @Autowired
    Environment env;
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
        return new UserServiceImpl(ui(), dbInterface(), parse());
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
        return new ParserImpl();
    }
}
