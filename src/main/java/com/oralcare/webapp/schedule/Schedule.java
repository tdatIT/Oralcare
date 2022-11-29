package com.oralcare.webapp.schedule;

import com.oralcare.webapp.variable.VariableScope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Schedule {

    private Random random = new Random();


    @Scheduled(fixedRate = 1000 * 3600)
    public void increase() {
        VariableScope.count_request += random.nextInt(20) + 10;
    }
}
