package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Test_table;

@Controller // Webリクエストを受け付けるクラスであることを示します
public class UserRegistrationController {

    private final com.example.demo.service.UserRegisterService userRegisterService;

    public UserRegistrationController(com.example.demo.service.UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    /**
     * 登録フォームを表示するためのメソッドです。
     * URL: http://localhost:8080/register
     */
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // フォームで使う空のUserオブジェクトを渡します
        model.addAttribute("test_table", new com.example.demo.domain.Test_table());
        return "registration_form"; // templates/registration_form.html を表示します
    }

    /**
     * フォームから送信されたデータを受け取り、登録処理を行うメソッドです。
     * @ModelAttributeを使うことで、フォームデータを自動でUserオブジェクトにマッピングします。
     */
    @PostMapping("/register")
    public String registerUser(
    		@ModelAttribute("test_table") Test_table test_table, 
            Model model
        ) {
            // Service層を経由してDBに登録します
            // ★ここを修正/補完しました
            Test_table savedUser = userRegisterService.register(test_table); 
            // ----------------------------------------------------

            // 登録完了メッセージを画面に表示するためにModelに詰めます
            model.addAttribute("message", "ユーザー「" + savedUser.getName() + "」をID:" + savedUser.getId() + "で登録しました。");
            return "registration_success"; // templates/registration_success.html を表示します
    }
    
 // UserRegistrationController.java の既存のクラス内に追記

    /**
     * ユーザーの一覧を表示するためのメソッドです。
     * URL: http://localhost:8080/list
     */
    @GetMapping("/list")
    public String showUserList(Model model) {
        // Service層を経由して全件データを取得します
        List<Test_table> userList = userRegisterService.findAll();
        
        // 取得したリストをModelに詰めてViewに渡します
        model.addAttribute("users", userList);
        
        return "user_list"; // templates/user_list.html を表示します
    }
    
    /**
     * トップページ（インデックス）を表示するためのメソッドです。
     * URL: http://localhost:8080/
     */
    @GetMapping("/")
    public String showTopPage() {
        return "index"; // templates/top_page.html を表示します
    }

}
  