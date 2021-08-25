package taskquestionanswers.task.service;

import taskquestionanswers.task.dto.QuestionDto;

import java.util.List;

public interface QuestionService {

    List<QuestionDto> getAllQuestions();

    QuestionDto getQuestionById(Integer questionId);

}
