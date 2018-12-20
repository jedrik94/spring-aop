package pl.jedrik94.demo.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Message {
    private String title;
    private String subtitle;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void sendTo(Account account) {}

    public List<Account> createListOfReceivers() {
        Account accA = new Account();
        accA.setName("A");
        accA.setEmail("a@a.a");

        Account accB = new Account();
        accB.setName("B");
        accB.setEmail("b@b.b");

        return Arrays.asList(accA, accB);
    }

    @Override
    public String toString() {
        return "Message{" +
                "title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
