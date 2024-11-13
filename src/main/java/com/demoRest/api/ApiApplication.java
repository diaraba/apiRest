package com.demoRest.api;

import com.demoRest.api.Enum.ERole;
import com.demoRest.api.entities.Role;
import com.demoRest.api.entities.User;
import com.demoRest.api.entities.Compte;
import com.demoRest.api.Enum.TypeCompte;
import com.demoRest.api.repositories.RoleRepository;
import com.demoRest.api.repositories.UserRepository;
import com.demoRest.api.repositories.CompteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	@Bean
	CommandLineRunner start(CompteRepository compteRepository, UserRepository userRepository, RoleRepository roleRepository){
		return args -> {
			/*
			User C1= userRepository.save(new User(null,"Diaraba",null));
			User C2= userRepository.save(new User(null,"Diarra",null));
			User C3= userRepository.save(new User(null,"Idrissa",null));
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.COURANT,C1));
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE,C2));
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.COURANT,C3));
			compteRepository.findAll().forEach(c->{
				System.out.println(c.getSolde());
			});
			roleRepository.save(new Role(null, ERole.ROLE_ADMIN));
			roleRepository.save(new Role(null, ERole.ROLE_CLIENT));
			roleRepository.save(new Role(null, ERole.ROLE_CAISSIER));

			 */
		};
	};
}
