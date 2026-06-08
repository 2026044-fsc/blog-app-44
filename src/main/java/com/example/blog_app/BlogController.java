package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    //サービスクラス型のフィールド
    private final BlogService blogService;

    //コンストラクタ
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    //メソッド
    @GetMapping("/blogs")
    public String brog() {
        return "blogs";
    }
    
}
