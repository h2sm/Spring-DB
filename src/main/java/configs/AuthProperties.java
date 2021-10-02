package configs;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthProperties {
    private String login;
    private String password;
    private String url;
}
