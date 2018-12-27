package pl.jedrik94.demo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {
    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Heavy traffic today!";
    }

    public String getFortune(boolean throwExceptionFlag) {
        if (throwExceptionFlag) {
            throw new RuntimeException("As you wished, exception thrown.");
        }

        return this.getFortune();
    }
}
