package pl.jedrik94.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO implements DAO {
    @Override
    public void addAccount() {
        System.out.println(this.toString());
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
