package com.university.lab06.model;

import com.university.lab06.exceptions.InvalidArticleDataException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Article {
    private static final Logger logger = LoggerFactory.getLogger(Article.class);
    
    private long id;
    private String title;
    private String content;
    private String author;
    private String publishedDate;
    private int views;
    
    public Article(long id, String title, String content, 
            String author, String publishedDate, int views) {
        setId(id);
        setTitle(title);
        setContent(content);
        setAuthor(author);
        setPublishedDate(publishedDate);
        setViews(views);
    }
    
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            logger.error("Ошибка валидации: title не может быть null или пустым");
            throw new InvalidArticleDataException("title не может быть null или пустым");
        }
        this.title = title;
    }
    
    public String getContent() { return content; }
    public void setContent(String content) {
        if (content == null || content.isBlank()) {
            logger.error("Ошибка валидации: content не может быть null или пустым");
            throw new InvalidArticleDataException("content не может быть null или пустым");
        }
        this.content = content;
    }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public String getPublishedDate() { return publishedDate; }
    public void setPublishedDate(String publishedDate) { this.publishedDate = publishedDate; }
    
    public int getViews() { return views; }
    public void setViews(int views) {
        if (views < 0) {
            logger.error("Ошибка валидации: views не может быть отрицательным");
            throw new InvalidArticleDataException("views не может быть отрицательным");
        }
        this.views = views;
    }
    
    @Override
    public String toString() {
        return String.format("Article{id=%d, title='%s', content='%s', author='%s', publishedDate='%s', views=%d}",
                id, title, content, author, publishedDate, views);
    }
}
