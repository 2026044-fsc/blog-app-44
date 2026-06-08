package com.example.blog_app;

import java.util.List;
import java.util.Optional;

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
    //メソッド
    public List<Blog> findAll() {
        return jdbcClient.sql("SELECT id, name, title, postDate, notes FROM blogs")
          .query(Blog.class)
          .list();
    }

    //Blog一覧からBlogをクリックする（idを選ぶ）と詳細ページに飛ぶようにする
    public Optional<Blog> findById(Long id) {
    return jdbcClient.sql("SELECT id, name, title, postDate, notes FROM blogs WHERE id = :id")
      .param("id", id)   //右の id は引数の id
      .query(Blog.class)
      .optional();   //戻り値の型に optional<> つける
  }
}
