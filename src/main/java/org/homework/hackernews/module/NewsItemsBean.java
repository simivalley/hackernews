package org.homework.hackernews.module;

import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class NewsItemsBean {


    private  final static Map<String, NewsItem> newsItems = new LinkedHashMap<>();


    public void addItem(NewsItem item){
        newsItems.put(item.getId(), item);
    }

    public Optional<NewsItem> getItem(String itemId){
      if ( newsItems.containsKey(itemId)) {
          return Optional.of(newsItems.get(itemId));
      }

        return Optional.empty();
    }

    public Map<String,NewsItem> getNewsItems (){
        return newsItems;

    }


    public void deleteAllItems(){
        newsItems.clear();


    }


}
