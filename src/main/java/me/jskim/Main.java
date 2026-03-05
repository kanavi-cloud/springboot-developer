package me.jskim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {  // 이름도 SpringBootDeveloperApplication로 바꾸면 더 깔끔
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}