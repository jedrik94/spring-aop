package pl.jedrik94.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
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
}
