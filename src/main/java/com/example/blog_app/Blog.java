package com.example.blog_app;

public class Blog {
    //フィールド
    private final Long id;
    private final String name;
    private final String title;
    private final String postDate;
    private final String notes;

    //コンストラクタ
    public Blog (Long id, String name, String title, String postDate, String notes) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.postDate = postDate;
        this.notes = notes;
    }

    //メソッド
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getTitle() {
        return title;
    }
    public String getPostDate() {
        return postDate;
    }
    public String getNotes() {
        return notes;
    }
}
