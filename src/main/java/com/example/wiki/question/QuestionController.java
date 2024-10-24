package com.example.wiki.question;

import java.security.Principal;

import com.example.wiki.answer.AnswerForm;
import com.example.wiki.user.SiteUser;
import com.example.wiki.user.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import lombok.RequiredArgsConstructor;

// 프리픽스(prefix)란 URL의 접두사 또는 시작 부분을 가리키는 말
@RequestMapping("/question") // QuestionController에 속하는 URL 매핑은 항상 /question 프리픽스로 시작하도록 설정
@RequiredArgsConstructor // questionRepository 객체를 주입
// final이 붙은 속성을 포함하는 생성자를 자동으로 만들어주는 역할
// 여기서 questionService 객체도 @RequiredArgsConstructor에 의해 생성자 방식으로 주입된다
@Controller
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        // Model 객체는 자바 클래스(Java class)와 템플릿(template) 간의 연결 고리 역할

        return "question_list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) { // id값을 얻어오기 // 404 ERROR 해결
        // Question 객체를 템플릿에 전달
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);

        return "question_detail";
    }

    @GetMapping("/create") // 404 ERROR 해결
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create") // 405('Method Not Allowed' ERROR 해결
    public String questionCreate(@Valid QuestionForm questionForm,
                                 BindingResult bindingResult, Principal principal) {    // question_form.html은 [질문 등록하기] 버튼을 통해 GET 방식으로 URL이 요청되더라도
    // th:object에 의해 QuestionForm 객체가 필요하기 때문에 파라미터를 넘겨 받아야지 오류가 발생하지 않는다
    // GET 방식에서도 question_form 템플릿에 QuestionForm 객체가 전달된다
    // QuestionForm과 같이 매개변수로 바인딩한 객체는 Model 객체로 전달하지 않아도 템플릿에서 사용할 수 있다.
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);


        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }

    // 메서드명은 @GetMapping에서 사용한 questionCreate 메서드명과 동일하게 사용할 수 있다
    // (단, 매개변수의 형태가 다른 경우에 가능하다)
    // 이와 같이 자바에서 한 클래스에서 동일한 메서드명을 사용할 수 있는 것을 메서드 오버라이딩(overloading)이라고 한다.

    // questionCreate 메서드의 매개변수를 subject, content 대신 QuestionForm 객체로 변경했다
    // subject, content 항목을 지닌 폼이 전송되면 QuestionForm의 subject, content 속성이 자동으로 바인딩 된다
    // 이렇게 이름이 동일하면 함께 연결되어 묶이는 것이 바로 폼의 바인딩 기능이다
}