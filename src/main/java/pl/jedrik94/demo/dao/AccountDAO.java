package pl.jedrik94.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount() {
        System.out.println("DEBUG (jedrik94): " + getClass());
    }
}

