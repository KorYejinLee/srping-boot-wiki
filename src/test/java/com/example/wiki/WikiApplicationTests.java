package com.example.wiki;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import com.example.wiki.answer.Answer;
import com.example.wiki.question.Question;
import com.example.wiki.question.QuestionRepository;
import com.example.wiki.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class WikiApplicationTests {

	@Autowired
	private QuestionService questionService;

	@Test
	void testJpa() {
	}
}