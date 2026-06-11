package com.example.blog_app;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {
    //JdbcClient型のフィールド
    private final JdbcClient jdbcClient;

    //コンストラクタ
    public BlogRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    //ブログ一覧を作成する
    public List<Blog> findAll() {
        return jdbcClient.sql("SELECT id, name, title, postDate, notes FROM blogs")
          .query(Blog.class)
          .list();
    }

    //Blog一覧からBlogをクリックする（idを選ぶ）と詳細ページに飛ぶようにする
    public List<Blog> findById(Long id) {
        return jdbcClient.sql("SELECT id, name, title, postDate, notes FROM blogs WHERE id = :id")
          .param("id", id)   //右の id は引数の id
          .query(Blog.class)
          .list();   
  }

    // 保存（フォームからの追加用）
    public void save(BlogForm form) {
        jdbcClient.sql("INSERT INTO blogs (name, title, notes) VALUES (:name, :title, :notes)")
            .param("name", form.getName())
            .param("title", form.getTitle())
            .param("notes", form.getNotes())
            .update();
    }
}
