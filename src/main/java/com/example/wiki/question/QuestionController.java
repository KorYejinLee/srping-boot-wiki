package com.example.wiki.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

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

    @GetMapping("/create") // 404 ERROR 해결
    public String questionCreate() {
        return "question_form";
    }

    @PostMapping("/create") // 405('Method Not Allowed' ERROR 해결
    public String questionCreate(@RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
        // TODO 질문을 저장한다.
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }

    // 메서드명은 @GetMapping에서 사용한 questionCreate 메서드명과 동일하게 사용할 수 있다
    // (단, 매개변수의 형태가 다른 경우에 가능하다)
    // 이와 같이 자바에서 한 클래스에서 동일한 메서드명을 사용할 수 있는 것을 메서드 오버라이딩(overloading)이라고 한다.

    // question_form.html에서 입력 항목으로 사용한 subject, content의 이름과
    // RequestParam이 value 값이 동일해야 함을 기억하자
    // 그래야 입력 항목으 값을 제대로 얻을 수 있다
}