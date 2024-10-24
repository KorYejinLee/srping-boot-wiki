package com.example.wiki.answer;

import com.example.wiki.DataNotFoundException;
import com.example.wiki.question.Question;
import com.example.wiki.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

    public Answer getAnswer(Integer id) {
        Optional<Answer> answer = this.answerRepository.findById(id);
        if (answer.isPresent()) {
            return answer.get();
        } else {
            throw new DataNotFoundException("answer not found");
        }
    }

    public void modify(Answer answer, String content) {
        Answer updatedAnswer = answer.toBuilder()
                .content(content)
                .modifyDate(LocalDateTime.now())
                .build();

        this.answerRepository.save(updatedAnswer);
    }

    public void delete(Answer answer) {
        this.answerRepository.delete(answer);
    }
}
