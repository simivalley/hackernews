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
import java.util.Optional;
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

        String topNewsLink = newsServicesLinks.getServiceLinks("top-news-link");

        String newsLink =  newsServicesLinks.getServiceLinks("news-link");



        RestTemplate restTemplate = new RestTemplate();
        final String response = restTemplate.getForObject(topNewsLink, String.class);

        List<Integer> topNewsList;
        topNewsList = objectMapper.readValue(response, LinkedList.class).subList(0, 10);



        logger.info ("topNewsList " + topNewsList);

        newsItemsBean.getNewsItems().clear();
        for (Integer topNewsId : topNewsList
        ) {
            String strTopNewsId = String.valueOf(topNewsId);
            String newsDetails = restTemplate.getForObject(newsLink + topNewsId + ".json", String.class);
            logger.info (" newsDetails :" + newsDetails);

            JsonNode jsonNodeTree = objectMapper.readTree(newsDetails);

            Optional<JsonNode> newsIdJsonNode = Optional.ofNullable(jsonNodeTree.get("id"));
            Optional<JsonNode> newsTitleJsonNode = Optional.ofNullable(jsonNodeTree.get("title"));
            Optional<JsonNode> newsUrlJsonNode = Optional.ofNullable(jsonNodeTree.get("url"));
            if (!newsUrlJsonNode.isPresent()) {
                logger.error("Url does not exist");
            }

            String newsIdStr = newsIdJsonNode.isPresent() ? newsIdJsonNode.get().asText() : "newId is not existed ";
            String newsTitleStr = newsTitleJsonNode.isPresent() ? newsTitleJsonNode.get().asText() : "newTitle is not existed ";
            String newsUrlStr = newsUrlJsonNode.isPresent() ? newsUrlJsonNode.get().asText() : "newUrl is not existed ";


            NewsItem newsItem = new NewsItem( newsIdStr, newsTitleStr , newsUrlStr);
            newsItemsBean.addItem(newsItem);

        }

    }
}
