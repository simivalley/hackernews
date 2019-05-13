package org.homework.hackernews.module;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.Map;

@Controller
public class HackerNewsController {

    private  final NewsItemsBean newsItemsBean;
    private  final TopNewsUpdater topNewsUpdater;


    public HackerNewsController(NewsItemsBean newsItemsBean,
                                TopNewsUpdater topNewsUpdater) {
        this.newsItemsBean = newsItemsBean;
        this.topNewsUpdater = topNewsUpdater;
    }

    @GetMapping("/hackernews")
    public String index(Map<String, Object> model)  throws IOException {
//
//        NewsItem testNewsItem = new NewsItem("100", "test news item-100", "http://www.example.com");
//        NewsItem testNewsItem1 = new NewsItem("200", "test news item-200", "http://www.yahoo.com");
//        newsItemsBean.addItem(testNewsItem);
//        newsItemsBean.addItem(testNewsItem1);

        topNewsUpdater.update();

        model.put("hackernews", newsItemsBean.getNewsItems().values().toArray());
        return "hackerNewsIndex";
    }




}
