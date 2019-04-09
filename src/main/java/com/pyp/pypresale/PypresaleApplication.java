package com.pyp.pypresale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //时间自动更新需要
public class PypresaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(PypresaleApplication.class, args);
    }

}
