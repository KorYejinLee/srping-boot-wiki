package com.example.wiki.answer;

import java.time.LocalDateTime;
import java.util.Set;

import com.example.wiki.question.Question;
import com.example.wiki.user.SiteUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer id;

    @Column(columnDefinition = "TEXT")
    private final String content;

    private final LocalDateTime createDate;

    @ManyToOne // N:1
    private final Question question;
    // 실제 데이터베이스에서는 왜래키(foreign key) 관계가 생성
    // 부모는 Question
    // 자식은 Answer

    @ManyToOne
    private final SiteUser author;

    private final LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;
}