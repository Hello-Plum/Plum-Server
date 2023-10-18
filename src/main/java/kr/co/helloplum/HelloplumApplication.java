package kr.co.helloplum;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kr.co.helloplum.domain.Meeting;
import kr.co.helloplum.service.MeetingService;

@SpringBootApplication
public class HelloplumApplication {


	public static void main(String[] args) {
		SpringApplication.run(HelloplumApplication.class, args);
	}

}
