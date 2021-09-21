package configuration;

import database.DBFactory;
import database.DBInterface;
import console.ConsolePrint;
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
    public ConsolePrint console() {
        return new ConsolePrint();
    }

    @Bean
    public DBInterface dbInterface() {
        return DBFactory.getInstance();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(console(), dbInterface());
    }
    @Bean
    public AuthProperties properties(){
        var p = new AuthProperties();
        p.setLogin(env.getProperty("docker.Login"));
        p.setPassword(env.getProperty("docker.Password"));
        p.setUrl(env.getProperty("docker.URL"));
        return p;
    }
}
