package com.example.testinfra.domain.board.domain;

import com.example.testinfra.domain.common.BaseEntity;
import com.example.testinfra.domain.user.domain.Student;

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
@Table(name = "bidding")
@Entity
public class Bidding extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bidding_no")
	private Long no;

	@NotNull
	private Integer biddingPrice;

	@NotNull
	@Enumerated(EnumType.STRING)
	private BiddingType biddingType;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_no")
	private Student student;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "board_no")
	private Board board;

	public Bidding(
		Integer biddingPrice,
		BiddingType biddingType,
		Student student,
		Board board
	) {
		this.biddingPrice = biddingPrice;
		this.biddingType = biddingType;
		this.student = student;
		this.board = board;
	}

	// update()
}

enum BiddingType {
	입찰, 낙찰, 유찰;
}
