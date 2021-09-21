package configuration;

import io.console.ConsolePrint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ConsolePrint console(){
        return new ConsolePrint();
    }

}
