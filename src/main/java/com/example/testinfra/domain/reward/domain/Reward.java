package com.example.testinfra.domain.reward.domain;

import com.example.testinfra.domain.grade.domain.Grade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "reward")
@Entity
public class Reward {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reward_no")
	private Long no;

	@NotNull
	private String name;

	@NotNull
	private String description;

	@NotNull
	private Integer price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grade_no")
	private Grade grade;

	public Reward(
		String name,
		String description,
		Integer price,
		Grade grade
	) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.grade = grade;
	}

	// update()
}
