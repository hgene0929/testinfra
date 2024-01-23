package com.example.testinfra.domain.user.domain;

import com.example.testinfra.domain.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "account")
@Entity
public class Account extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_no")
	private Long no;

	@NotNull
	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	@NotNull
	private Integer price;

	@NotNull
	private String content;

	@NotNull
	@Enumerated(EnumType.STRING)
	private DealType dealType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_no")
	private Student student;

	public Account(
		AccountType accountType,
		Integer price,
		String content,
		DealType dealType,
		Student student
	) {
		this.accountType = accountType;
		this.price = price;
		this.content = content;
		this.dealType = dealType;
		this.student = student;
	}
}

enum AccountType {
	지출, 수입;
}

enum DealType {
	경매, 리워드, 주급, 적금;
}
