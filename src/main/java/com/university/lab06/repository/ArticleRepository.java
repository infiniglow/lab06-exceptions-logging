package com.university.lab06.repository;

import com.university.lab06.exceptions.ArticleNotFoundException;
import com.university.lab06.model.Article;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class ArticleRepository {
    private static final Logger logger = LoggerFactory.getLogger(ArticleRepository.class);
    
    private final Map<Long, Article> storage = new HashMap<>();
    private long nextId = 1;
    
    public long save(Article article) {
        logger.info("Сохранение статьи: {}", article.getTitle());
        long id = nextId++;
        article.setId(id);
        storage.put(id, article);
        logger.info("Статья успешно сохранена: id={}, title={}", article.getId(), article.getTitle());
        return id;
    }
    
    public Article findById(long id) throws ArticleNotFoundException {
        Article article = storage.get(id);
        if (article == null) {
            logger.warn("Попытка получить статью с id {}", id);
            throw new ArticleNotFoundException("Статья с id " + id + " не найдена");
        }
        return article;
    }
    
    public void delete(long id) throws ArticleNotFoundException {
        Article removed = storage.remove(id);
        if (removed == null) {
            logger.warn("Попытка удалить статью с id {}", id);
            throw new ArticleNotFoundException("Статья с id " + id + " не найдена");
        }
        logger.info("Статья успешно удалена: id={}, title={}", id, removed.getTitle());
    }
    
    public Map<Long, Article> findAll() {
        return new HashMap<>(storage);
    }
}
