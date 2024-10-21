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
		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals(1, q.getId());
	}

	// '인터페이스에 findBySubject'라는 메서드를 선언만 하고 구현하지 않았는데 도대체 어떻게 실행되는 거지?'
	// 이러한 마법은 JAP에 리포지터리의 메서드명을 분석하여 쿼리를 만들고 실행하는 기능이 있기 때문에 가능하다
	// 즉 findBy + 엔티티의 속성명(예를 들어 findBySubject)와 같은 리포지터리의 메서드를 작성하면
	// 입력한 속성의 값으로 데이터를 조회할 수 있다!
}