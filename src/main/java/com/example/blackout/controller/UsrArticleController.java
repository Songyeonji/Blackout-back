package com.example.blackout.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.blackout.vo.Article;

@Controller
@RequestMapping("/usr/article")
public class UsrArticleController {

    private List<Article> articles;
    private int lastArticleId;

    UsrArticleController() {
        this.articles = new ArrayList<>();
        this.lastArticleId = 0;
    }

    @PostMapping("/doWrite")
    @ResponseBody
    public ResponseEntity<Article> doWrite(@RequestBody Article article) {
        this.lastArticleId++;
        article.setId(this.lastArticleId);

        articles.add(article);

        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    @RequestMapping("/showList")
    @ResponseBody
    public List<Article> showList() {
        return this.articles;
    }
}

