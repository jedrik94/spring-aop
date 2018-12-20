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
        Account account = context.getBean("account", Account.class);

        System.out.println("DEBUG (App): " + accountDAO.getClass().getName());
        System.out.println();

        accountDAO.addAccount();
        System.out.println();

        accountDAO.addAccount(new Account());
        System.out.println();
        accountDAO.addAccount(new Account(), true);
        System.out.println();
        accountDAO.deleteAccount();
        System.out.println();
        accountDAO.updateAccount();
        System.out.println();
        accountDAO.updateMembership();

        System.out.println("\n");
        System.out.println("DEBUG (App): " + membershipDAO.getClass().getName());
        System.out.println();

        membershipDAO.addAccount();
        System.out.println();
        membershipDAO.deleteAccount();
        System.out.println();
        membershipDAO.updateAccount();
        System.out.println();
        membershipDAO.updateMembership();

        System.out.println("\n");
        System.out.println("DEBUG (App): " + Account.class);
        System.out.println();

        account.setName("Jedrzej Wojtkowiak");
        account.setEmail("jedrik94@gmail.com");
        System.out.println("DEBUG (App - main()): " + account.getName() + " " + account.getEmail());
        account.describeYourself();

        context.close();
    }
}
