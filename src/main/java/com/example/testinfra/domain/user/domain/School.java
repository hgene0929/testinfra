package com.example.testinfra.domain.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "school")
@Entity
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "school_no")
	private Long no;

	@NotNull
	private String name;

	@NotNull
	private String region;

	@NotNull
	private String code;

	public School(
		String name,
		String region,
		String code
	) {
		this.name = name;
		this.region = region;
		this.code = code;
	}

	// update()
}
