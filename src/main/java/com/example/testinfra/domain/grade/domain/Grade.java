package com.example.testinfra.domain.grade.domain;

import java.time.LocalTime;

import com.example.testinfra.domain.common.BaseEntity;
import com.example.testinfra.domain.user.domain.Admin;

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
@Table(name = "grade")
@Entity
public class Grade extends BaseEntity { // TODO: 학급 class -> java 예약어 수정 필요 학급 Grade, 학년 year?

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "grade_no")
	private Long no;

	@NotNull
	private Integer asset = 0;

	@NotNull
	private Integer year;

	@NotNull
	private Integer classRoom;

	@NotNull
	private Integer salary;

	@NotNull
	private LocalTime transferAlertPeriod;

	@NotNull
	private LocalTime transferPeriod;

	// TODO: 통계 컬럼들 nullable 괜찮?
	private String highestRiseCoupon;

	private String highestFallCoupon;

	private String frequentCouponFirst;

	private String frequentCouponSecond;

	private String frequentCouponThird;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_no")
	private Admin admin;

	public Grade(
		Integer asset,
		Integer year,
		Integer classRoom,
		Integer salary,
		LocalTime transferAlertPeriod,
		LocalTime transferPeriod,
		String highestRiseCoupon,
		String highestFallCoupon,
		String frequentCouponFirst,
		String frequentCouponSecond,
		String frequentCouponThird,
		Admin admin
	) {
		this.asset = asset;
		this.year = year;
		this.classRoom = classRoom;
		this.salary = salary;
		this.transferAlertPeriod = transferAlertPeriod;
		this.transferPeriod = transferPeriod;
		this.highestRiseCoupon = highestRiseCoupon;
		this.highestFallCoupon = highestFallCoupon;
		this.frequentCouponFirst = frequentCouponFirst;
		this.frequentCouponSecond = frequentCouponSecond;
		this.frequentCouponThird = frequentCouponThird;
		this.admin = admin;
	}

	// update()
}
