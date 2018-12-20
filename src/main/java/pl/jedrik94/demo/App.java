package pl.jedrik94.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.jedrik94.demo.config.DemoConfig;
import pl.jedrik94.demo.model.Account;
import pl.jedrik94.demo.model.Message;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        Message message = context.getBean("message", Message.class);

        System.out.println("DEBUG (App): " + message.getClass().getName());

        System.out.println("DEBUG (App - main()): setTitle()");
        message.setTitle("Hello!!");

        System.out.println("DEBUG (App - main()): setSubtitle()");
        message.setSubtitle("How's going?!");

        System.out.println("DEBUG (App - main()): setContent()");
        message.setContent("See u soon!! Cya");

        System.out.println("DEBUG (App - main()): sendTo()");
        message.sendTo(new Account());

        System.out.println("DEBUG (App - main()): createListOfReceivers()");
        message.createListOfReceivers();

        context.close();
    }
}
