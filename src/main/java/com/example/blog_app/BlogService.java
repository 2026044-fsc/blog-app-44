package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
    //リポジトリ型のフィールド
    private final BlogRepository blogRepository;

    //コンストラクタ
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
    //ブログ一覧を作成する
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    //ブログ一覧からブログをクリックすると詳細ページに飛ぶようにする
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }
}
