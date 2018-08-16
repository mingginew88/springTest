package syj.login.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:syj/config/spring/root-context.xml",
								"classpath:syj/config/spring/servlet-context.xml",
								"classpath:syj/config/spring/datasource_dev.xml",
								"classpath:syj/config/spring/transaction.xml"})
@WebAppConfiguration
public class LoginControllerTest {

	//@Autowired
	@Resource
	private WebApplicationContext context;
	
	//mockMvc
	private MockMvc mvc;
	
	@Before
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
	@Test
	public void loginTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(get("/login/view")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();

		/***Then***/
		assertEquals("login/login2", mav.getViewName());	
	}
	
	
	@Test
	public void loginProcessTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(post("/login/loginProcess").param("loginId", "syjun88").param("loginPassword", "3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();
		String loginId = (String) mav.getModel().get("loginId");

		/***Then***/
		assertEquals("login/login2", mav.getViewName());
		assertEquals("syjun88", loginId);
	}
	
	
	@Test
	public void joinTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(get("/login/join")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();

		/***Then***/
		assertEquals("login/join", mav.getViewName());
	}
	
	
	@Test
	public void joinProcessTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(get("/login/joinProcess")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();

		/***Then***/
		assertEquals("login/login2", mav.getViewName());
	}
	
	
	@Test
	public void logoutTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(get("/login/logout")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();

		/***Then***/
		assertEquals("login/login2", mav.getViewName());
	}
	
	
	@Test
	public void mainTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(get("/login/main")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();

		/***Then***/
		assertEquals("main/main", mav.getViewName());
	}
		
	
	
	

}
