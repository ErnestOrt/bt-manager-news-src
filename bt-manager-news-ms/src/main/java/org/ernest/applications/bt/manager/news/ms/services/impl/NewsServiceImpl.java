package org.ernest.applications.bt.manager.news.ms.services.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.ernest.applications.bt.manager.news.ct.Article;
import org.ernest.applications.bt.manager.news.ct.exceptions.RetrieveNewsException;
import org.ernest.applications.bt.manager.news.ms.services.NewsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

@Component
public class NewsServiceImpl implements NewsService{
	String URL = "http://www.cyclingnews.com";

	@Override
	public List<Article> get() throws RetrieveNewsException {
		
		try{
			
			return Jsoup.connect(URL + "/news/").userAgent("Mozilla/5.0")
										 .timeout(10000)
										 .get()
										 .select("header.post-header")
										 .stream()
										 .map(element -> { return buildArticle(element); })
								         .collect(Collectors.toList());

		}catch(Exception e){
			e.printStackTrace();
			throw new RetrieveNewsException(e.getMessage());
		}
	}

	private Article buildArticle(Element element) {
		Article article = new Article();

		article.setTitle(element.getElementsByClass("post-title").get(0).getElementsByTag("a").text());
		article.setUrl(URL + element.getElementsByClass("post-title").get(0).getElementsByTag("a").attr("href"));
		article.setDescription(element.getElementsByClass("post-synopsis").text());
		try {
			article.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(element.getElementsByClass("datetime").attr("datetime")));
		} catch (Exception e) {
			article.setDate(new Date());
		}
		return article;
	}
}