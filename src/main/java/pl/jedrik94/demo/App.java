package pl.jedrik94.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.jedrik94.demo.config.DemoConfig;
import pl.jedrik94.demo.dao.AccountDAO;
import pl.jedrik94.demo.dao.MembershipDAO;
import pl.jedrik94.demo.model.Account;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        accountDAO.addAccount();
        accountDAO.addAccount(new Account());
        accountDAO.addAccount(new Account(), true);
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
