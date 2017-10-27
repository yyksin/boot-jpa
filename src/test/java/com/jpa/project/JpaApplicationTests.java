package com.jpa.project;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Profile("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {


//	@Value("${yyk.message}") String msg;
//	@Autowired
//    UsersRepository userRepository;
//
//	@Autowired
//	Environment environment;
//
//	@Test
//	public void contextLoads() {
//		System.out.println(msg);
//		List<Users> users = userRepository.findAll();
//		System.out.println(environment.getProperty("yyk.message"));
//	}
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void home() throws Exception{
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/").param("name", "yyk"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
