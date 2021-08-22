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

    @PostMapping("/create/question")
    public ResponseEntity<QuestionDto> createQuestion(@RequestBody QuestionDto questionDto) {
        return ResponseEntity.ok(questionService.createQuestion(questionDto));
    }

    @PutMapping("/update/question")
    public ResponseEntity<QuestionDto> updateQuestion(@RequestBody QuestionDto questionDto) {
        return ResponseEntity.ok(questionService.updateQuestion(questionDto));
    }

    @DeleteMapping("/delete/question/{questionId}")
    public void deleteQuestion(@PathVariable("questionId") Integer questionId) {
         questionService.deleteQuestion(questionId);
    }

    @GetMapping("/get/question/{questionId}")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable("questionId") Integer questionId) {
        return ResponseEntity.ok(questionService.getQuestionById(questionId));
    }

}
