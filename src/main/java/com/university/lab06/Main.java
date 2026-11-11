package com.university.lab06;

import com.university.lab06.repository.ArticleRepository;
import com.university.lab06.model.Article;
import com.university.lab06.exceptions.InvalidArticleDataException;
import com.university.lab06.exceptions.ArticleNotFoundException;

public class Main {
    public static void main(String[] args) {
        ArticleRepository repository = new ArticleRepository();
        
        try {
            Article article = new Article(1L, "Название", "Содержание", 
                    "Автор", "01.01.2000", 0);
            repository.save(article);
            System.out.println("Статья успешно сохранена\n");
        } catch (InvalidArticleDataException e) {
            System.err.println("Ошибка при создании статьи: " + e.getMessage());
        }
        System.out.println();
        
        try {
            Article found = repository.findById(999L);
            System.out.println("Найдена книга: " + found);
        } catch (ArticleNotFoundException e) {
            System.err.println("Ошибка при удалении статьи: " + e.getMessage());
        }
        System.out.println();
        
        try {
            Article invalidArticle = new Article(2L, "", "Содержание_2", "Автор_2", "02.02.2000", 0);
            System.err.println("Ошибка: статья с неверными данными была создана!");
        } catch (InvalidArticleDataException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        }
        
        processFile("article.csv");
    }
    
    private static void processFile(String filePath) {
        System.out.println("Обработка файла: " + filePath);
        System.out.println("Файл успешно обработан (имитация)");
    }
}
