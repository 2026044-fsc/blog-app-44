package com.example.blog_app;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
    //リポジトリ型のフィールド
    private final BlogRepository blogRepository;

    //コンストラクタ
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
    //メソッド
}
