package com.example.wiki.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

// 프리픽스(prefix)란 URL의 접두사 또는 시작 부분을 가리키는 말
@RequestMapping("/question") // QuestionController에 속하는 URL 매핑은 항상 /question 프리픽스로 시작하도록 설정
@RequiredArgsConstructor // questionRepository 객체를 주입
// final이 붙은 속성을 포함하는 생성자를 자동으로 만들어주는 역할
// 여기서 questionService 객체도 @RequiredArgsConstructor에 의해 생성자 방식으로 주입된다
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        // QuestionController가 리포지터리 대신 서비스를 사용
        model.addAttribute("questionList", questionList);
        // Model 객체는 자바 클래스(Java class)와 템플릿(template) 간의 연결 고리 역할
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) { // id값을 얻어오기 // 404 ERROR 해결
        // Question 객체를 템플릿에 전달
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
}