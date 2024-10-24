package com.example.wiki.answer;

import com.example.wiki.question.Question;
import com.example.wiki.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    // 입력받은 2개의 매개변수인 question과 content를 사용하여 Answer 객체를 생성하여 저장
    public void create(Question question, String content, SiteUser author) {
        Answer answer = Answer.builder()
                .content(content)
                .createDate(LocalDateTime.now())
                .question(question)
                .author(author)
                .build();

        this.answerRepository.save(answer);
    }

}
