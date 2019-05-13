package org.homework.hackernews.module;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class NewsItem {
    private String id;
    private String title;
    private String url;

    @JsonIgnore
    private String by;

    @JsonIgnore
    private int descendants;

    public NewsItem(){}


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


    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public int getDescendants() {
        return descendants;
    }

    public void setDescendants(int descendants) {
        this.descendants = descendants;
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
