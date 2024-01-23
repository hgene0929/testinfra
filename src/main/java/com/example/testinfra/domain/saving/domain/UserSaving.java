package com.example.testinfra.domain.saving.domain;

import java.time.LocalDateTime;

import com.example.testinfra.domain.user.domain.Student;

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
@Table(name = "user_saving")
@Entity
public class UserSaving {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_saving_no")
	private Long no;

	@NotNull
	private LocalDateTime startPeriod;

	@NotNull
	private LocalDateTime endPeriod;

	@NotNull
	private Integer currentPrice = 0;

	@NotNull
	private Integer resultPrice;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "saving_no")
	private Saving saving;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_no")
	private Student student;

	public UserSaving(
		LocalDateTime startPeriod,
		LocalDateTime endPeriod,
		Integer currentPrice,
		Integer resultPrice,
		Saving saving,
		Student student
	) {
		this.startPeriod = startPeriod;
		this.endPeriod = endPeriod;
		this.currentPrice = currentPrice;
		this.resultPrice = resultPrice;
		this.saving = saving;
		this.student = student;
	}

	// update()
}
