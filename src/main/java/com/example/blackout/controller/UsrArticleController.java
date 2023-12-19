package com.example.blackout.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.blackout.service.ArticleService;
import com.example.blackout.vo.Article;


@Controller
public class UsrArticleController {

    private final ArticleService articleService;

    public UsrArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/usr/article/showList")
    @ResponseBody
    public List<Article> showList() {
        return articleService.getArticles();
    }


    @PostMapping("/usr/article/doWrite")
    @ResponseBody
    public ResponseEntity<Article> doWrite(@RequestBody Article vo) {
        Article article = articleService.writeArticle(vo);
        return ResponseEntity.ok(article);
    }


    // ... (이후 코드 생략)
}