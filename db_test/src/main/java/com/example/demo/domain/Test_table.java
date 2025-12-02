package com.example.demo.domain;

/*
 * デーブルのEntity
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
	private integer chiryoku;
	@Column(name = "tousotsu", nullable = true, columnDefinition = "integer default 0")
	private integer tousotsu;
	@Column(name = "miryoku", nullable = true, columnDefinition = "integer default 0")
	private integer miryoku;
	@Column(name = "seimu", nullable = true, columnDefinition = "integer default 0")
	private integer seimu;

}
