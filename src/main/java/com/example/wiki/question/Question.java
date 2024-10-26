package com.example.wiki.question;

import java.time.LocalDateTime;
import java.util.List;

import com.example.wiki.answer.Answer;
import com.example.wiki.user.SiteUser;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder; // 상속과 함께 사용시
import lombok.Getter;
import java.util.Set;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
// @NoArgsConstructor
// @AllArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer id;

    @Column(length = 200)
    private final String subject;

    @Column(columnDefinition = "TEXT")
    private final String content;

    private final LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private final List<Answer> answerList;

    @ManyToOne
    private final SiteUser author;

    private final LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;
}