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
	@Column(name = "buryoku")
	private int buryoku;
	@Column(name = "chiryoku")
	private int chiryoku;
	@Column(name = "tousotsu")
	private int tousotsu;
	@Column(name = "miryoku")
	private int miryoku;
	@Column(name = "seimu")
	private int seimu;

}
