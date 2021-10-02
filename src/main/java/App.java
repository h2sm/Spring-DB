import configs.AppConfiguration;
import userInteraction.EntryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        var x = new AnnotationConfigApplicationContext(AppConfiguration.class);
        var userService = x.getBean("userService", EntryService.class);
        userService.start();
    }
}