package org.homework.hackernews.module;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class NewsItemsBeanTest {

    private NewsItemsBean newsItemsBean = new NewsItemsBean();

    @Test
    public void addItem() throws Exception {
        NewsItem testNewsItem = new NewsItem("100", "test news item", "http://www.example.com");

        newsItemsBean.getNewsItems().clear();
        newsItemsBean.addItem(testNewsItem);

        int actualSize = newsItemsBean.getNewsItems().size();
        int expectedSize = 1;

        assertThat(actualSize).isEqualTo(expectedSize);
    }

    @Test
    public void getItem() throws Exception {
        NewsItem testNewsItem = new NewsItem("200", "test news item", "http://www.example-test.com");
        newsItemsBean.addItem(testNewsItem);

        Optional<NewsItem> actualItemOptional = newsItemsBean.getItem(testNewsItem.getId());

        NewsItem actualNewsItem = actualItemOptional.get();

        assertThat(actualNewsItem).isEqualTo(testNewsItem);


    }

    @Test
    public void deleteAll() throws Exception{
        NewsItem testNewsItem1 = new NewsItem("200", "test news item", "http://www.example-test.com");
        newsItemsBean.getNewsItems().clear();

        int actualSize = newsItemsBean.getNewsItems().size();
        int expectedSize = 0;

        assertThat(actualSize).isEqualTo(expectedSize);
    }

}
