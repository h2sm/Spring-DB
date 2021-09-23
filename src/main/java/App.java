import configuration.AppConfiguration;
import configuration.AuthProperties;
import logics.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {
        var x = new AnnotationConfigApplicationContext(AppConfiguration.class);
        /*var pr = x.getBean("properties", AuthProperties.class);
        System.out.println(pr.getLogin() + " " + pr.getPassword() + " " + pr.getUrl());;*/
        var code = x.getBean("userService", UserServiceImpl.class);
        code.start();
    }
}