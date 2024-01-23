package com.example.testinfra.domain.user.domain;

import com.example.testinfra.domain.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // TODO: 상속 관계 맵핑 전략?
@DiscriminatorColumn(name = "DTYPE")
@Table(name = "users")
@Entity
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "users_no")
	private Long no;

	@NotNull
	private String id;

	@NotNull
	private String password;

	@NotNull
	private String name;

	@NotNull
	private String birthDate;

	@NotNull
	private Integer asset = 0;

	@NotNull
	private Integer ballCount = 0;

	@NotNull
	private String avatarImgUrl;

	@NotNull
	private String attendance; // TODO: Embedded 타입 사용?

	public User(
		String id,
		String password,
		String name,
		String birthDate,
		Integer asset,
		Integer ballCount,
		String avatarImgUrl,
		String attendance
	) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.birthDate = birthDate;
		this.asset = asset;
		this.ballCount = ballCount;
		this.avatarImgUrl = avatarImgUrl;
		this.attendance = attendance;
	}

	// update()
}
