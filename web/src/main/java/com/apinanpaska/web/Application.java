package com.apinanpaska.web;

import com.apinanpaska.web.onlinechess.OnlineChess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		OnlineChess.run();
		System.out.println("toimii");
	}
}
