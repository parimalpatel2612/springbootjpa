package com.jpa.bootjpa;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpa.bootjpa.dao.UserRepository;
import com.jpa.bootjpa.entities.User;

@SpringBootApplication
public class SpringbootjpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =    SpringApplication.run(SpringbootjpaApplication.class, args);
		UserRepository userrepo = context.getBean(UserRepository.class);
		
		//save
//		User user1 = new User("parimal1", "delhi1", "ad");
//		User user2 = new User("parimal2", "delh21", "adffd");
//	
//		
//		List<User> lstOfUser = (List<User>) userrepo.saveAll(List.of(user1, user2));
//
//		lstOfUser.forEach(user ->System.out.println(user));
		
		
		
//		Optional<User> optional = userrepo.findById(18);
//		
//		User user = optional.get();
//		System.out.println(user);
//		user.setCity("Gujarat");
//		user.setName("Mahes");
//		
//		user = userrepo.save(user);
//		
//		System.out.println(user);
		
//		List<User> allUser = (List<User>) userrepo.findAll();
		List<User> allUser = (List<User>) userrepo.getAllUser();
		allUser.forEach(user -> System.out.println(user));
		
		User userByName = userrepo.getUserByName("Mahes");
		System.out.println(userByName);
		
		User userByNamea = userrepo.getUserByNameAndCity("Mahes", "Gujarat");
		System.out.println(userByNamea);
		
		
		List<User> allUserbyNative = (List<User>) userrepo.getUsers();
		allUserbyNative.forEach(user -> System.out.println(user));
		
	}

}
