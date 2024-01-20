package com.example.testinfra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestApi {

	private final TestEntityRepository testEntityRepository;

	@GetMapping("/")
	public String test() {
		int idx = testEntityRepository.findAll().size();

		TestEntity testEntity = new TestEntity();
		testEntity.setName("ENTITY " + idx+1);

		testEntityRepository.save(testEntity);

		return "BUILD SUCCEEDED!!!";
	}
}
