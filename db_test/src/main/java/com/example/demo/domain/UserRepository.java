package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Userエンティティ（データ型）と、主キーの型（integer）を指定します
@Repository
public interface UserRepository extends JpaRepository<Test_table, Integer> {
    // このインターフェースを定義するだけで、データの保存や検索のメソッドが使えるようになります。
}