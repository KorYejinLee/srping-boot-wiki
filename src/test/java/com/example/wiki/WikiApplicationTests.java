package com.example.wiki;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {

	@Autowired // 스프링의 '의존성 주입(DI)' 기능
	private QuestionRepository questionRepository;

	@Test // testJpa 메서드가 테스트 매서드임을 나타냄
	void testJpa() {
		List<Question> all = this.questionRepository.findAll(); // question 테이블에 저장된 모든 데이터를 조회
		// SELECT * FROM QUESTION
		assertEquals(2, all.size()); // assertEquals(기댓값, 실젯값)

		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}
}