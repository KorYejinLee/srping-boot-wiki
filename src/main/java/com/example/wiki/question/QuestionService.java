package com.example.wiki.question;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // @Service 애너테이션이 붙은 클래스를 서비스로 인식하므로 서비스를 쉽게 생성 가능
public class QuestionService {

    private final QuestionRepository questionRepository;
    // questionRepository 객체는 @RequiredArgsConstructor에 의해 생성자 방식으로 주입된다

    public List<Question> getList() {
        return this.questionRepository.findAll();
        // 이전에 QuestionController에서 사용했던 부분을 그대로 옮긴 것을 알 수 있다
    }
}