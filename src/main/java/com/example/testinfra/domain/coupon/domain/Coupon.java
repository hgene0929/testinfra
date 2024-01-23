package com.example.testinfra.domain.coupon.domain;

import com.example.testinfra.domain.common.BaseEntity;
import com.example.testinfra.domain.grade.domain.Grade;

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
@Table(name = "coupon")
@Entity
public class Coupon extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coupon_no")
	private Long no;

	@NotNull
	private String name;

	@NotNull
	private String description;

	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusType statusType;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "grade_no")
	private Grade grade;

	public Coupon(
		String name,
		String description,
		StatusType statusType,
		Grade grade
	) {
		this.name = name;
		this.description = description;
		this.statusType = statusType;
		this.grade = grade;
	}

	// update()
}

enum StatusType {
	승인전, 승인후;
}
