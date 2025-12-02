package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PathVariable; // ★

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
     * 編集フォームを表示するためのメソッドです。
     * URL: http://localhost:8080/edit/{id}
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        // Service層経由でIDに該当するユーザーデータを取得します
        Test_table user = userRegisterService.findById(id);

        // フォームで使うオブジェクトとしてModelに渡します
        model.addAttribute("test_table", user);
        
        // registration_form.htmlを編集フォームとして再利用します
        return "registration_form"; 
    }

    /**
     * 更新処理を行うメソッドです。登録処理（/registerのPOST）とほぼ同じです。
     * IDが存在するため、自動的に更新（UPDATE）が実行されます。
     */
    @PostMapping("/edit") // パスは/registerと分けておくと安全です
    public String updateUser(@ModelAttribute("test_table") Test_table test_table, Model model) {
        // IDを含んだ状態でServiceのregister（=save）を呼び出します
        Test_table savedUser = userRegisterService.register(test_table);

        model.addAttribute("message", "ユーザー「" + savedUser.getName() + "」をID:" + savedUser.getId() + "で**更新**しました。");
        return "registration_success"; // 成功画面を表示
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
  
