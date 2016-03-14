package org.ernest.applications.bt.manager.news.ms.services;

import java.util.List;

import org.ernest.applications.bt.manager.news.ct.Article;
import org.ernest.applications.bt.manager.news.ct.exceptions.RetrieveNewsException;

public interface NewsService {
	
	List<Article> get() throws RetrieveNewsException;
}
