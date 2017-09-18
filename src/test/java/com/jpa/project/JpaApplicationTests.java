package com.jpa.project;

import com.jpa.project.model.Users;
import com.jpa.project.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Profile("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {


	@Value("${yyk.message}") String msg;
	@Autowired
	UserRepository userRepository;

	@Autowired
	Environment environment;

	@Test
	public void contextLoads() {
		System.out.println(msg);
		List<Users> users = userRepository.findAll();
		System.out.println(environment.getProperty("yyk.message"));
	}
}
