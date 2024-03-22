package com.auth.ws;

import com.auth.ws.candidate.service.CandidateService;
import com.auth.ws.company.entity.AppCompany;
import com.auth.ws.company.service.CompanyService;
import com.auth.ws.employer.entity.AppEmployer;
import com.auth.ws.employer.service.EmployerService;
import com.auth.ws.user.entity.AppUser;
import com.auth.ws.user.entity.enums.UserRole;
import com.auth.ws.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthWsApplication.class, args);
	}


	@Bean
	CommandLineRunner createInitialUsers(UserService userService, CandidateService candidateService, EmployerService employerService, CompanyService companyService) {
		return (args) -> {

			AppUser user2 = new AppUser ("rfk", "378378", UserRole.EMPLOYER);
			userService.register(user2);

			AppCompany appCompany=new AppCompany("mühendislik","1246466");
			companyService.register(appCompany);

			AppEmployer appUserEmployer=new AppEmployer( "rıfkı sarıcı",user2,appCompany);
			employerService.register(appUserEmployer);

			AppUser adminUser = new AppUser("rıfkı", "378378",UserRole.ADMIN);
			userService.register(adminUser);

			AppCompany appCompany2=new AppCompany("google","1246466");
			companyService.register(appCompany2);

		};
	}

	@Bean
	CommandLineRunner endInitial() {
		return (args) -> {
			System.out.println("\n*********************Initial constant value successful...***************************");
		};
	}
}
