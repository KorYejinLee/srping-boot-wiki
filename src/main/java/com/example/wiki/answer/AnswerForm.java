package com.example.wiki.answer;

import jakarta.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class AnswerForm {
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
}