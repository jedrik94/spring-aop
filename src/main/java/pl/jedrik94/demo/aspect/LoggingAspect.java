package pl.jedrik94.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import pl.jedrik94.demo.model.Account;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(* pl.jedrik94.demo.dao.*.*(..))")
    private void pointcutDAOPackage() {}

    @Pointcut("execution(* pl.jedrik94.demo.model.*.*(..))")
    private void pointcutModelPackage() {}

    @Pointcut("execution(* pl.jedrik94.demo.model.*.get*(..))")
    private void pointcutModelPackageGetters() {}

    @Pointcut("execution(* pl.jedrik94.demo.model.*.set*(..))")
    private void pointcutModelPackageSetters() {}

    @Pointcut("pointcutModelPackage() && !(pointcutModelPackageGetters() || pointcutModelPackageSetters())")
    private void pointcutModelPackageWithoutGetterAndSetters() {}

    @Before("execution(public void addAccount(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("DEBUG (jedrik94): Executing @Before advice on addAccount(..)");
    }

    @Before("execution(public void addAccount(pl.jedrik94.demo.model.Account))")
    public void beforeAddAccountOneParamAdvice() {
        System.out.println("DEBUG (jedrik94): Executing @Before advice on addAccount(pl.jedrik94.demo.model.Account)");
    }

    @Before("execution(public void addAccount(pl.jedrik94.demo.model.Account, *))")
    public void beforeAddAccountMoreParamsAdvice() {
        System.out.println("DEBUG (jedrik94): Executing @Before advice on addAccount(pl.jedrik94.demo.model.Account, *)");
    }

    @Before("execution(void pl.jedrik94.demo.dao.AccountDAO.deleteAccount())")
    public void beforeDeleteAccountAdvice() {
        System.out.println("DEBUG (jedrik94): Executing @Before advice on specific deleteAccount()");
    }

    @Before("execution(* update*())")
    public void beforeUpdateAdvice() {
        System.out.println("DEBUG (jedrik94): Executing @Before advice on any update*()");
    }

    @Before("pointcutDAOPackage()")
    public void beforeDAOClasses() {
        System.out.println("DEBUG (jedrik94): Executing @Before advice on any pl.jedrik94.demo.dao class method");
    }

    @Before("pointcutModelPackageWithoutGetterAndSetters()")
    public void beforeModelClasses(JoinPoint joinPoint) {
        System.out.println("DEBUG (jedrik94): Executing @Before advice on any pl.jedrik94.demo.model class method except getters and setter");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("DEBUG (joinPoint): method signature - " + signature);

        Object[] args = joinPoint.getArgs();

        for (Object arg : args){
            System.out.println("DEBUG (joinPoint): arg - " + arg);
        }
    }

    @AfterReturning(pointcut = "execution(* pl.jedrik94.demo.model.Message.createListOfReceivers())",
    returning = "result")
    public void afterReturningMessage(JoinPoint joinPoint, List<Account> result) {
        System.out.println("DEBUG (afterReturning): List<Account> - " + result);
    }
}
