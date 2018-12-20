package pl.jedrik94.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Account {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void describeYourself() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
