package org.homework.hackernews.module;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class NewsServicesLinks {


    private final String topNewsService;

    public NewsServicesLinks(String topNewsService) {
        this.topNewsService = topNewsService;
    }

    public String getServiceLinks(String serviceLink) {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode root;

        try {
            root = objectMapper.readTree(topNewsService);
        } catch (IOException e) {
            throw new IllegalStateException("No TOP_NEWS_SERVICE found", e);
        }

        JsonNode services = root.path(serviceLink);


        return services.get(serviceLink).asText();


    }
}
