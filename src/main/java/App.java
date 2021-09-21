import configuration.Config;
import console.ConsolePrint;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {
    public static void main(String[] args) {
        var console = new AnnotationConfigApplicationContext(Config.class)
                .getBean("console", ConsolePrint.class);
        console.read();
    }
}
