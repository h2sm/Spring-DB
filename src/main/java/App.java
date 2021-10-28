import configs.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        var x = new AnnotationConfigApplicationContext(AppConfiguration.class);
        var entry = x.getBean("userService", EntryService.class);
        entry.start();
    }
}