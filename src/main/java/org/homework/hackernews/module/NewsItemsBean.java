package org.homework.hackernews.module;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class NewsItemsBean {


    private final static Map<String, NewsItem> newsItems = new LinkedHashMap<>();


    public void addItem(NewsItem item){
        newsItems.put(item.getId(), item);
    }

    public Optional<NewsItem> getItem(String itemId){
      if ( newsItems.containsValue(itemId)) {
          return Optional.of(newsItems.get(itemId));
      }

        return Optional.empty();
    }
}
