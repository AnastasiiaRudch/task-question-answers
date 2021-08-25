package taskquestionanswers.task.service;

import taskquestionanswers.task.dto.QuestionDto;

import java.util.List;

public interface QuestionService {

    List<QuestionDto> getAllQuestions();

    QuestionDto createQuestion(QuestionDto questionDto);

    QuestionDto updateQuestion(QuestionDto questionDto);

    void deleteQuestion(Integer questionId);

    QuestionDto getQuestionById(Integer questionId);

}
