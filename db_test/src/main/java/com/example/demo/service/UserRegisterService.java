package com.example.demo.service;

import java.util.List; // ★これを追加

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Test_table; // ★これを追加
import com.example.demo.domain.UserRepository; // ★これを追加

@Service
@Transactional
public class UserRegisterService {

    private final UserRepository userRepository; // importしたので、フルパス不要

    public UserRegisterService(UserRepository userRepository) { // importしたので、フルパス不要
        this.userRepository = userRepository;
    }

    /**
     * ユーザー情報をデータベースに登録します。
     * @param user 登録するUserオブジェクト
     * @return 登録後のUserオブジェクト
     */
    public Test_table register(Test_table test_table) { // importしたので、フルパス不要
        return userRepository.save(test_table);
    }
        
    /**
     * 【★ここを追加】データベースに登録されている全ユーザー情報を取得します
     */
    @Transactional(readOnly = true) // 読み取り専用トランザクションにすることでパフォーマンス向上
    public List<Test_table> findAll() {
        // Spring Data JPAのCrudRepository/JpaRepositoryが提供するfindAll()を使います
        return userRepository.findAll();
    
    }
}