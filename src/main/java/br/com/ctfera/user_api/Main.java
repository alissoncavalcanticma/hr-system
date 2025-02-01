package br.com.ctfera.user_api;

import br.com.ctfera.user_api.domain.User;
import br.com.ctfera.user_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	//Método sobrescrito da interface CommandLineRunner implementada acima
	@Override
	public void run(String... args) throws Exception {

		userRepository.saveAll(List.of(
				new User(null,"Alisson","alisson@gmail.com", "123", 23.20)
		));

	}
}
