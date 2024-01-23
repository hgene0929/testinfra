package com.example.testinfra.domain.board.domain;

import com.example.testinfra.domain.common.BaseEntity;
import com.example.testinfra.domain.user.domain.User;

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
@Table(name = "board")
@Entity
public class Board extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_no")
	private Long no;

	@NotNull
	private String couponName;

	@NotNull
	private String description;

	@NotNull
	private Integer startPrice;

	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusType statusType = StatusType.진행중;

	@NotNull
	@Enumerated(EnumType.STRING)
	private UserType userType;

	@NotNull
	private Integer totalPrice = 0;

	@NotNull
	private Integer attendeeCount = 0;

	private Integer resultPrice;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_no")
	private User user;

	// TODO: 교시를 풀어내는 방법? N:M 맵핑테이블 방식 or 그냥 맵핑하지 않고 자료구조로?
	// 교시

	public Board(
		String couponName,
		String description,
		Integer startPrice,
		StatusType statusType,
		UserType userType,
		Integer totalPrice,
		Integer attendeeCount,
		Integer resultPrice,
		User user
	) {
		this.couponName = couponName;
		this.description = description;
		this.startPrice = startPrice;
		this.statusType = statusType;
		this.userType = userType;
		this.totalPrice = totalPrice;
		this.attendeeCount = attendeeCount;
		this.resultPrice = resultPrice;
		this.user = user;
	}

	// update()
}

enum StatusType {
	진행중, 경매완료;
}

enum UserType {
	학생, 관리자;
}
