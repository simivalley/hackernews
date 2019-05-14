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

        topNewsUpdater.update();

        model.put("hackernews", newsItemsBean.getNewsItems().values().toArray());
        return "hackerNewsIndex";
    }




}
