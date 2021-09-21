package configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:dockerConfig.properties")
public class Properties {
    @Value("${docker.Login}")
    @Getter
    private String login;

    @Value("${docker.Password}")
    @Getter
    private String password;

    @Value("${docker.URL}")
    @Getter
    private String url;
}
