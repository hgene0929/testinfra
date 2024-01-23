package com.example.testinfra.domain.saving.domain;

import com.example.testinfra.domain.common.BaseEntity;
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
@Table(name = "saving")
@Entity
public class Saving extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "saving_no")
	private Long no;

	@NotNull
	private String name;

	@NotNull
	private Integer depositPeriod;

	@NotNull
	private Integer depositCycle;

	@NotNull
	private Integer depositPrice;

	@NotNull
	private Integer interestRate;

	@NotNull
	private String terms;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grade_no")
	private Grade grade;

	public Saving(
		String name,
		Integer depositPeriod,
		Integer depositCycle,
		Integer depositPrice,
		Integer interestRate,
		String terms,
		Grade grade
	) {
		this.name = name;
		this.depositPeriod = depositPeriod;
		this.depositCycle = depositCycle;
		this.depositPrice = depositPrice;
		this.interestRate = interestRate;
		this.terms = terms;
		this.grade = grade;
	}

	// update()
}
