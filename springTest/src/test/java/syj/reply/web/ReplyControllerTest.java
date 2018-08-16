package syj.reply.web;

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
public class ReplyControllerTest {

	//@Autowired
	@Resource
	private WebApplicationContext context;
	
	//mockMvc
	private MockMvc mvc;
	
	@Before
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
//	@Test
	public void deleteReplyTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(get("/board/deleteReply").param("article_no", "1").param("reply_no", "1")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();
		int article_no = (Integer) mav.getModel().get("article_no");

		/***Then***/
		assertEquals("redirect:/article/articleDetail?article_no="+article_no, mav.getViewName());
	}

	
//	@Test
	public void addReplyTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(get("/board/addReply").param("article_no", "1").param("reply_content", "123").sessionAttr("sessionId", "syjun88")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();
		int article_no = (Integer) mav.getModel().get("article_no");

		/***Then***/
		assertEquals("redirect:/article/articleDetail?article_no="+article_no, mav.getViewName());
	}


}
