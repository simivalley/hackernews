package org.homework.hackernews.module;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class TopNewsUpdater {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final NewsItemsBean newsItemsBean;
    private final NewsServicesLinks newsServicesLinks;

    public TopNewsUpdater(NewsItemsBean newsItemsBean, NewsServicesLinks newsServicesLinks) {
        this.newsItemsBean = newsItemsBean;
        this.newsServicesLinks = newsServicesLinks;
    }

    public void update() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

//        String topNewsLink = newsServicesLinks.getServiceLinks("top-news-link");
//
//        String newsLink =  newsServicesLinks.getServiceLinks("news-link");

        String topNewsLink = "https://hacker-news.firebaseio.com/v0/topstories.json";

        String newsLink = "https://hacker-news.firebaseio.com/v0/item/";


        RestTemplate restTemplate = new RestTemplate();
        final String response = restTemplate.getForObject(topNewsLink, String.class);

        List<Integer> topNewsList;
        topNewsList = objectMapper.readValue(response, LinkedList.class).subList(0, 10);

        //logger.debug("topNewsList : "  )

        System.out.println ( "topNewsList " + topNewsList);

        newsItemsBean.getNewsItems().clear();
        for (Integer topNewsId:topNewsList
        ) {
            String strTopNewsId= String.valueOf(topNewsId);
            String newsDetails = restTemplate.getForObject(newsLink+topNewsId+".json", String.class);

//            JsonNode jsonNode = objectMapper.readTree(newsDetails);
//            String newsUrl = jsonNode.get("url").asText();
//            System.out.println(newsUrl);

//            NewsItem newsItem = objectMapper.readValue( newsDetails, NewsItem.class);
//            newsItemsBean.addItem(newsItem);

        }

    }
}
