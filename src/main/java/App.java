import configuration.AppConfiguration;
import configuration.Properties;
import logics.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
        var x = new AnnotationConfigApplicationContext(AppConfiguration.class);
        var c = x.getBean("properties", Properties.class);
        System.out.println(c.getLogin() + " " + c.getPassword() + " " + c.getUrl());
    }
}
