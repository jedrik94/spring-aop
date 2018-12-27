package pl.jedrik94.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.jedrik94.demo.config.DemoConfig;
import pl.jedrik94.demo.dao.AccountDAO;
import pl.jedrik94.demo.model.Account;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        boolean throwExceptionFlag = false;

        try {
            Account account = accountDAO.findAccountByEmail("zbyszek@gmail.com", throwExceptionFlag);
        } catch (Exception e) {
            System.out.println("DEBUG (App): Exception");
            System.out.println("DEBUG (AppException): " + e.getMessage());
        }

        context.close();
    }
}
