package com.example.wiki;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		// Return type Question이 아닌 Optional 이다
		// Optional은 그 값을 처리하기 위한(null값을 유연하게 처리하기 위한) 클래스
		if(oq.isPresent()) { // 값이 존재하는지 확인
			Question q = oq.get();
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
	}
}