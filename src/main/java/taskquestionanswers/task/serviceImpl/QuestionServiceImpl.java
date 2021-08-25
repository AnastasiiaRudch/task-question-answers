package taskquestionanswers.task.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskquestionanswers.task.dto.QuestionDto;
import taskquestionanswers.task.entity.QuestionEntity;
import taskquestionanswers.task.exceptions.QuestionIsNotExistException;
import taskquestionanswers.task.mapper.QuestionMapper;
import taskquestionanswers.task.repository.QuestionRepository;
import taskquestionanswers.task.service.QuestionService;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionMapper questionMapper;


    @Override
    public List<QuestionDto> getAllQuestions() {

        return questionMapper.collectionToList(questionRepository.findAll(), questionMapper.questionToDto);
    }

    @Override
    public QuestionDto getQuestionById(Integer questionId) {

        QuestionEntity questionEntity = questionRepository.findById(questionId)
                .orElseThrow(QuestionIsNotExistException::new);

        return questionMapper.getQuestionDto(questionEntity);
    }

}
