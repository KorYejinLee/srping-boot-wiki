package com.example.wiki;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {

	@Autowired // 스프링의 '의존성 주입(DI)' 기능
	private QuestionRepository questionRepository;

	@Test // testJpa 메서드가 테스트 매서드임을 나타냄
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get(); // 기존 객체 가져오기
		// 기존 객체를 기반으로 수정된 새로운 객체 생성
		Question updatedQuestion = q.toBuilder()
				.subject("수정된 제목입니다") // 제목만 수정
				.build(); // 새로운 객체 생성

		// 수정된 객체 저장
		this.questionRepository.save(updatedQuestion);
	}
}