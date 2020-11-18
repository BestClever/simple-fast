package com.halfsummer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.halfsummer.**.mapper")
public class SimpleFastApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleFastApplication.class, args);
    }

}
