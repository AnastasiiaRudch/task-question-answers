package taskquestionanswers.task.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taskquestionanswers.task.dto.QuestionDto;
import taskquestionanswers.task.entity.QuestionEntity;
import taskquestionanswers.task.exceptions.QuestionIsAlreadyExistException;
import taskquestionanswers.task.exceptions.QuestionIsNotExistException;
import taskquestionanswers.task.mapper.QuestionMapper;
import taskquestionanswers.task.repository.QuestionRepository;
import taskquestionanswers.task.service.QuestionService;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionMapper questionMapper;


    @Override
    public List<QuestionDto> getAllQuestions() {

        return questionMapper.collectionToList(questionRepository.findAll(), questionMapper.questionToDto);
    }


    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {

        QuestionEntity questionEntity = questionMapper.getQuestionEntity(questionDto);

        if(questionRepository.findById(questionEntity.getId()).isPresent()){
            throw new QuestionIsAlreadyExistException("Such Question is already exist");
        }

        questionRepository.save(questionEntity);
        return questionMapper.getQuestionDto(questionEntity);
    }


    @Override
    public QuestionDto updateQuestion(QuestionDto questionDto) {

        QuestionEntity questionEntity = questionRepository.findById(questionDto.getId())
                .orElseThrow(QuestionIsNotExistException::new);

        if(questionDto.getQuestion() != null){
            questionEntity.setQuestion(questionDto.getQuestion());
        }
        if(questionDto.getAnswers() != null){
            questionEntity.setAnswers(questionDto.getAnswers());
        }
        if(questionDto.getRightAnswer() != null){
            questionEntity.setRightAnswer(questionDto.getRightAnswer());
        }

        questionRepository.save(questionEntity);
        return questionMapper.getQuestionDto(questionEntity);
    }


    @Override
    public void deleteQuestion(Integer questionId) {

        QuestionEntity questionEntity = questionRepository.findById(questionId)
                .orElseThrow(QuestionIsNotExistException::new);

        questionRepository.delete(questionEntity);
    }


    @Override
    public QuestionDto getQuestionById(Integer questionId) {

        QuestionEntity questionEntity = questionRepository.findById(questionId)
                .orElseThrow(QuestionIsNotExistException::new);

        return questionMapper.getQuestionDto(questionEntity);
    }

}
