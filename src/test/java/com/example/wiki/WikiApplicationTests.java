package com.example.wiki;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository; // AnswerRepository의 객체를 @Autowired를 통해 주입

	@Test // testJpa 메서드가 테스트 매서드임을 나타냄
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(2);
		// questionRepository의 findById()를 통해 id가 2인 질문 데이터를 가져와 답변 question 속성에 대입해 답변 데이터 생성
		assertTrue(oq.isPresent());
		Question q = oq.get();

		Answer a = Answer.builder()
				.content("네, 자동으로 생성됩니다.") // 답변 내용 설정
				.question(q) // 질문 객체 설정
				.createDate(LocalDateTime.now()) // 현재 날짜 설정
				.build(); // 객체 생성

		this.answerRepository.save(a); // 생성된 객체 저장

	}
}