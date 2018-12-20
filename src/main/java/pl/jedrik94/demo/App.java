package pl.jedrik94.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.jedrik94.demo.config.DemoConfig;
import pl.jedrik94.demo.dao.DAO;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        DAO accountDAO = context.getBean("accountDAO", DAO.class);
        DAO membershipDAO = context.getBean("membershipDAO", DAO.class);

        accountDAO.addAccount();
        accountDAO.deleteAccount();
        accountDAO.updateAccount();
        accountDAO.updateMembership();

        System.out.println("\n");

        membershipDAO.addAccount();
        membershipDAO.deleteAccount();
        membershipDAO.updateAccount();
        membershipDAO.updateMembership();

        context.close();
    }
}
