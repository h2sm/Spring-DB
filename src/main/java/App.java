import configuration.AppConfiguration;
import configuration.AuthProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
        var x = new AnnotationConfigApplicationContext(AppConfiguration.class);
        var pr = x.getBean("properties", AuthProperties.class);
        System.out.println(pr.getLogin() + " " + pr.getPassword() + " " + pr.getUrl());;
    }
}
