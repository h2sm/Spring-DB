import configuration.AppConfiguration;
import configuration.AuthProperties;
import logics.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
        var x = new AnnotationConfigApplicationContext(AppConfiguration.class);
        var userService = x.getBean("userService", UserServiceImpl.class);
        userService.start();
    }
}