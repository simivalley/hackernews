package org.homework.hackernews.module;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class HackerNewsController {

    private  final NewsItemsBean newsItemsBean;


    public HackerNewsController(NewsItemsBean newsItemsBean) {
        this.newsItemsBean = newsItemsBean;
    }

    @GetMapping("/hackernews")
    public String index(Map<String, Object> model){

        NewsItem testNewsItem = new NewsItem("100", "test news item-100", "http://www.example.com");
        newsItemsBean.addItem(testNewsItem);

        model.put("hackernews", newsItemsBean.getNewsItems().values().toArray());
        return "hackerNewsIndex";
    }




}
