package com.example.blackout.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.blackout.dao.ArticleDao;
import com.example.blackout.vo.Article;

@Service
public class ArticleService {
    
    private ArticleDao articleDao;
    
    public ArticleService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }
    
    public Article writeArticle(Article vo) {
        return articleDao.writeArticle(vo.getTitle(), vo.getBody());
    }
    
    public List<Article> getArticles() {
        return articleDao.getArticles();
    }
    
    public Article getArticleById(int id) {
        return articleDao.getArticleById(id);
    }
    
    public void modifyArticle(Article article, String title, String body) {
        articleDao.modifyArticle(article, title, body);
    }
    
    public void deleteArticle(Article article) {
        articleDao.deleteArticle(article);
    }
    
}