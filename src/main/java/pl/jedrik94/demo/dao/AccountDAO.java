package pl.jedrik94.demo.dao;

import org.springframework.stereotype.Component;
import pl.jedrik94.demo.model.Account;

@Component
public class AccountDAO implements DAO {
    @Override
    public void addAccount() {
        System.out.println(this.toString());
    }

    public void addAccount(Account account) {
        System.out.println(this.toString());
    }

    public void addAccount(Account account, boolean isVIP) {
        System.out.println(this.toString());
    }

    public Account findAccountByEmail(String email, boolean throwExceptionFlag) {
        if (throwExceptionFlag) {
            throw new RuntimeException("No such a account in database.");
        } else {
            return new Account();
        }
    }

    @Override
    public void deleteAccount() {
        System.out.println(this.toString());
    }

    @Override
    public void updateAccount() {
        System.out.println(this.toString());
    }

    @Override
    public String updateMembership() {
        System.out.println(this.toString());
        return "";
    }

    @Override
    public String toString() {
        return "DEBUG (jedrik94): " + this.getClass();
    }
}

