package com.example.testinfra.domain.coupon.domain;

import java.time.LocalDateTime;

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
@Table(name = "user_coupon")
@Entity
public class UserCoupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_coupon_no")
	private Long no;

	@NotNull
	@Enumerated(EnumType.STRING)
	private UseType useType;

	private LocalDateTime updated_at;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "coupon_no")
	private Coupon coupon;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_no")
	private Student student;

	public UserCoupon(
		UseType useType,
		LocalDateTime updated_at,
		Coupon coupon,
		Student student
	) {
		this.useType = useType;
		this.updated_at = updated_at;
		this.coupon = coupon;
		this.student = student;
	}
}

enum UseType {
	승인전, 승인후;
}
