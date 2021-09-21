package configuration;

import database.DBFactory;
import database.DBInterface;
import console.ConsolePrint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ConsolePrint console(){
        return new ConsolePrint();
    }
    @Bean
    public DBInterface dbInterface(){
        return DBFactory.getInstance();
    }

}
