package com.example.wiki.question;

import java.util.List;
import java.util.Optional;

import com.example.wiki.DataNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // @Service 애너테이션이 붙은 클래스를 서비스로 인식하므로 서비스를 쉽게 생성 가능
public class QuestionService {

    private final QuestionRepository questionRepository;
    // questionRepository 객체는 @RequiredArgsConstructor에 의해 생성자 방식으로 주입된다

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) { // 해당 데이터(여기서는 id값)가 존재하는지 검사
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
            // id값에 해당하는 질문 데이터가 없을 경우에는 예외 클래스인 DataNotFoundException이 실행
        }
    }
}