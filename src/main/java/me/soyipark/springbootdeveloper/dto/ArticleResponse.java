package me.soyipark.springbootdeveloper.dto;

import lombok.Getter;
import me.soyipark.springbootdeveloper.domain.Article;

@Getter
public class ArticleResponse {
    //응답용 객체

    private String title;
    private String content;

    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
