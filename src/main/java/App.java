import configuration.AppConfiguration;
import logics.UserService;;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        var x = new AnnotationConfigApplicationContext(AppConfiguration.class);
        var userService = x.getBean("userService", UserService.class);
        userService.start();
    }
}