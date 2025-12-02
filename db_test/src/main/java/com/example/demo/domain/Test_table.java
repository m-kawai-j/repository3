package com.example.demo.domain;

/*
 * デーブルのEntity
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import lombok.Data;

@Entity // これがデータベースのテーブルに対応する、という印です
@Data // LombokがGetter/Setterなどを自動で生成してくれます
public class Test_table {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String organization;
	@Column(name = "buryoku", nullable = true, columnDefinition = "integer default 0")
	private Integer buryoku;
	@Column(name = "chiryoku", nullable = true, columnDefinition = "integer default 0")
	private Integer chiryoku;
	@Column(name = "tousotsu", nullable = true, columnDefinition = "integer default 0")
	private Integer tousotsu;
	@Column(name = "miryoku", nullable = true, columnDefinition = "integer default 0")
	private Integer miryoku;
	@Column(name = "seimu", nullable = true, columnDefinition = "integer default 0")
	private Integer seimu;

}
