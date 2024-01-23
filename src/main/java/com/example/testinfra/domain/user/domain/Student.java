package com.example.testinfra.domain.user.domain;

import com.example.testinfra.domain.grade.domain.Grade;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue("student")
public class Student extends User {

	@ManyToOne(targetEntity = Grade.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "grade_no")
	private Grade grade;

	private String frequentCouponFirst;

	private String frequentCouponSecond;

	private String frequentCouponThird;

	public Student(
		String id,
		String password,
		String name,
		String birthDate,
		Integer asset,
		Integer ballCount,
		String avatarImgUrl,
		String attendance,
		Grade grade,
		String frequentCouponFirst,
		String frequentCouponSecond,
		String frequentCouponThird
	) {
		super(id, password, name, birthDate, asset, ballCount, avatarImgUrl, attendance);
		this.grade = grade;
		this.frequentCouponFirst = frequentCouponFirst;
		this.frequentCouponSecond = frequentCouponSecond;
		this.frequentCouponThird = frequentCouponThird;
	}

	// update()
}
