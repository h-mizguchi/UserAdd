package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 入力フォーム表示
    @GetMapping("/")
    public String showInputForm(Model model) {
        model.addAttribute("user", new User());
        return "input";
    }

    // 入力内容を確認画面へ送る
    @PostMapping("/confirm")
    public String confirmInput(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "confirm";
    }

    // ユーザー情報をデータベースに登録
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.saveUser(user);
        return "result"; // 登録完了画面
    }

    // 確認画面から戻る
    @PostMapping("/back")
    public String backToInput(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "input";
    }
    
}
