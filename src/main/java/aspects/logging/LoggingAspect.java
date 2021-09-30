package aspects.logging;

import localization.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class LoggingAspect{
private final MessageService ms;
    @Before("@annotation(Loggable))")
    public void logThis(JoinPoint jopo) {
        String methodName = jopo.getSignature().getName();
        Object[] methodArgs = jopo.getArgs();
        var className = jopo.getTarget().getClass().getSimpleName();
        log.info(ms.localize("logging.call") + methodName + " from class " +  className);
    }

}
