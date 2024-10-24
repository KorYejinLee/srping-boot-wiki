package com.example.wiki.answer;

import com.example.wiki.question.Question;
import com.example.wiki.question.QuestionService;
import com.example.wiki.user.SiteUser;
import com.example.wiki.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserService userService;


    // POST 요청을 처리하는 경우에 사용
    @PostMapping("/create/{id}") // POST 방식은 주로 데이터를 저장하는 용도로 사용한다는 점 상기
    public String createAnswer(Model model, @PathVariable("id") Integer id,
                               @Valid AnswerForm answerForm, BindingResult bindingResult, Principal principal) {
        Question question = this.questionService.getQuestion(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());

        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }

        this.answerService.create(question, answerForm.getContent(), siteUser);

        return String.format("redirect:/question/detail/%s", id);
    }
}
