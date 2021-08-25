package taskquestionanswers.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import taskquestionanswers.task.dto.QuestionDto;
import taskquestionanswers.task.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @GetMapping("/get/all/questions")
    public ResponseEntity<List<QuestionDto>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/get/question/{questionId}")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable("questionId") Integer questionId) {
        return ResponseEntity.ok(questionService.getQuestionById(questionId));
    }

}
