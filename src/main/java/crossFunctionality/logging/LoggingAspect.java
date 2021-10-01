package crossFunctionality.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("@annotation(crossFunctionality.logging.Loggable))")
    public void log(JoinPoint jopo) {
        String methodName = jopo.getSignature().getName();
        var className = jopo.getTarget().getClass().getSimpleName();
        var args = jopo.getArgs();
        log.info("method:" + methodName + " from class " + className + " with args " + Arrays.toString(args));
    }


}
