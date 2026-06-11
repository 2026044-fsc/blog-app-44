package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BlogController {
    //サービスクラス型のフィールド
    private final BlogService blogService;

    //コンストラクタ
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    //ブログ一覧画面へのアクセス
    @GetMapping("/blogs")
    public String blog(Model model) {
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "blogs";
    }

    //アプリの入り口を開く
    @GetMapping("/")
    public String entrance() {
        return "redirect:/blogs";
    }
    
    //新規投稿画面へのアクセス
    @GetMapping("/blogs/new")
    public String newblog() {
        return "blogs/new";
    }

    //新規投稿画面から投稿ボタンを押すと一覧に加わる
    @PostMapping("/blogs")
    public String blogPlus(@ModelAttribute BlogForm form, Model model) {
        blogService.save(form);
        return "redirect:/blogs";
    }
    
    //ブログ一覧から本をクリックすると詳細ページに飛ぶようにする
    @GetMapping("/blogs/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Blog> blogOpt = blogService.findById(id);
        if ( blogOpt.isEmpty()) {
            return "redirect:/blogs";
        }
        model.addAttribute("blog", blogOpt.get());
        return "blogs/detail";
  }
    
}
