package syj.board.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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
public class BoardControllerTest {

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
	public void boardListTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(get("/board/boardList")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();

		/***Then***/
		assertEquals("board/boardList", mav.getViewName());
	}

	
//	@Test
	public void addBoardTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(get("/board/addBoard")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();

		/***Then***/
		assertEquals("redirect:/board/boardList", mav.getViewName());
	}
	
	
//	@Test
	public void updateBoardTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(get("/board/updateBoard")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();

		/***Then***/
		assertEquals("redirect:/board/boardList", mav.getViewName());
	}
	
	
	@Test
	public void showBoardListTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(get("/board/showBoardList").param("board_no", "1").param("page", "1").param("pageSize", "10")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();

		/***Then***/
		assertEquals("board/showBoardList", mav.getViewName());
	}
	

}
