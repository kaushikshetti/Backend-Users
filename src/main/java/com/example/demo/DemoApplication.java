package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	@Autowired
	public DemoApplication(UserRepository userRepository){
		this.userRepository=userRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(userRepository.findAll().isEmpty()){
			userRepository.save(new User("Kaushik","Shetti"));
			userRepository.save(new User("Eren","Yeager"));

		}
		for(User user: userRepository.findAll()){
			System.out.println(user);
		}

	}
}
