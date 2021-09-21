package configuration;

import database.DBFactory;
import database.DBInterface;
import console.ConsolePrint;
import logics.UserService;
import logics.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
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
    public Properties properties(){
        return new Properties();
    }
}
