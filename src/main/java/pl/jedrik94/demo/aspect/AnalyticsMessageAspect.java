package pl.jedrik94.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AnalyticsMessageAspect {
    @Before("execution(* pl.jedrik94.demo.model.Message.*(..))")
    public void showAnalytics() {
        System.out.println("DEBUG (jedrik94): " + this.getClass());
    }
}
