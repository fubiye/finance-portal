package com.biye.finance.ebidding.cdo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.biye.finance.ebidding")
public class FinanceBiddingCdoSpringStarterApplication {
    public static void main(String[] args){
        SpringApplication.run(FinanceBiddingCdoSpringStarterApplication.class,args);
    }
}
