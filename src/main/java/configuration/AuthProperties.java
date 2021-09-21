package configuration;

import lombok.Getter;
import lombok.Setter;

public class AuthProperties {
    @Setter
    @Getter
    private String login;
    @Setter
    @Getter
    private String password;
    @Setter
    @Getter
    private String url;

}
