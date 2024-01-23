package com.example.testinfra.domain.user.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DiscriminatorValue("admin")
public class Admin extends User {

	private String tel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "school_no")
	private School school;

	public Admin(
		String id,
		String password,
		String name,
		String birthDate,
		Integer asset,
		Integer ballCount,
		String avatarImgUrl,
		String attendance,
		String tel,
		School school
	) {
		super(id, password, name, birthDate, asset, ballCount, avatarImgUrl, attendance);
		this.tel = tel;
		this.school = school;
	}

	// update()
}
