package com.biye.finance.ebidding.cdo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.biye.finance.ebidding")
@EnableScheduling
public class FinanceBiddingCdoSpringStarterApplication {
    public static void main(String[] args){
        SpringApplication.run(FinanceBiddingCdoSpringStarterApplication.class,args);
    }
}
