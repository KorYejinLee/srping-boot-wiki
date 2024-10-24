package com.example.wiki.question;

import java.time.LocalDateTime;
import java.util.List;

import com.example.wiki.answer.Answer;
import com.example.wiki.user.SiteUser;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder; // 상속과 함께 사용시
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor // 그래서 달아줌
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    // 질문을 삭제하면 그에 달린 답변들도 모두 삭제
    // Answer 엔티티에서 Question 엔티티를 참조한 속성인 question을 mappedBy에 전달
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;
}