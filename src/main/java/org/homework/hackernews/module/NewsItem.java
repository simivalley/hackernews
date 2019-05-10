package org.homework.hackernews.module;

import java.util.Objects;

public class NewsItem {
    private String id;
    private String title;
    private String url;

    public NewsItem(String id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsItem newsItem = (NewsItem) o;
        return id.equals(newsItem.id) &&
                title.equals(newsItem.title) &&
                url.equals(newsItem.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, url);
    }


}
