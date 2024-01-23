package com.example.testinfra.domain.classperiod.domain;

import java.time.LocalTime;

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
@Table(name = "class_period")
@Entity
public class ClassPeriod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "class_period_no")
	private Long no;

	@NotNull
	private Integer sequence;

	@NotNull
	private LocalTime startPeriod;

	@NotNull
	private LocalTime endPeriod;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grade_no")
	private Grade grade;

	public ClassPeriod(
		Integer sequence,
		LocalTime startPeriod,
		LocalTime endPeriod,
		Grade grade
	) {
		this.sequence = sequence;
		this.startPeriod = startPeriod;
		this.endPeriod = endPeriod;
		this.grade = grade;
	}

	// update()
}
