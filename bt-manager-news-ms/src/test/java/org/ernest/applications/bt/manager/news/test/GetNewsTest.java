package org.ernest.applications.bt.manager.news.test;

import java.util.Arrays;

import org.ernest.applications.bt.manager.news.ct.Article;
import org.ernest.applications.bt.manager.news.ms.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest({"server.port=0"})
public class GetNewsTest {
	
	@Value("${local.server.port}")
	String port;
	
	@Test
	public void retrieveNews(){
		Assert.assertTrue(Arrays.asList(new RestTemplate().getForObject("http://localhost:"+port+"/getnews", Article[].class)).size() > 0);
	}
}