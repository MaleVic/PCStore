package com.example.PCStore;

import com.example.PCStore.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class PcStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcStoreApplication.class, args);
	}

}
