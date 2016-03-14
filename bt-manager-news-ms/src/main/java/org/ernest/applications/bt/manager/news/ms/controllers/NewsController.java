package org.ernest.applications.bt.manager.news.ms.controllers;

import java.util.List;

import org.ernest.applications.bt.manager.news.ct.Article;
import org.ernest.applications.bt.manager.news.ct.exceptions.RetrieveNewsException;
import org.ernest.applications.bt.manager.news.ms.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

	@Autowired
	NewsService newsService;
	
	@RequestMapping(path = "/getnews", method = RequestMethod.GET)
	public List<Article> create() throws RetrieveNewsException {
		return newsService.get();
	}
}