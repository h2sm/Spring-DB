import configuration.Config;
import console.ConsolePrint;
import logics.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;


public class App {
    public static void main(String[] args) {
        var x = new AnnotationConfigApplicationContext(Config.class)
                .getBean("userService", UserService.class);
        x.retrieveCommand();
    }
}
