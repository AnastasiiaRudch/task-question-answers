package taskquestionanswers.task.mapper;

import org.springframework.stereotype.Service;
import taskquestionanswers.task.dto.QuestionDto;
import taskquestionanswers.task.entity.QuestionEntity;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class QuestionMapper {

        public Function<QuestionEntity, QuestionDto> questionToDto = this::getQuestionDto;
        public Function<QuestionDto, QuestionEntity> questionToEntity = this::getQuestionEntity;

        public <A, R> List<R> collectionToList(Collection<A> collection, Function<A, R> mapper) {
            return collection.stream().map(mapper).collect(Collectors.toList());
        }


    public QuestionEntity getQuestionEntity(QuestionDto questionDto){
            return QuestionEntity.builder()
                    .id(questionDto.getId())
                    .question(questionDto.getQuestion())
                    .rightAnswer(questionDto.getRightAnswer())
                    .build();
    }

        public QuestionDto getQuestionDto(QuestionEntity questionEntity){
            return QuestionDto.builder()
                    .id(questionEntity.getId())
                    .question(questionEntity.getQuestion())
                    .rightAnswer(questionEntity.getRightAnswer())
                    .build();
        }
}
