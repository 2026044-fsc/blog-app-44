package com.example.blog_app;

public class BlogForm {
    private String name;
    private String title;
    private String notes;

    public BlogForm(String name,String title, String notes) {
        this.name = name;
        this.title = title;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }
    public String getTitle() {
        return title;
    }
    public String getNotes() {
        return notes;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}

