package taskquestionanswers.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import taskquestionanswers.task.entity.QuestionEntity;
import taskquestionanswers.task.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TaskQuestionAnswersApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskQuestionAnswersApplication.class, args);
    }

    @Bean
    CommandLineRunner init(QuestionRepository questionRepository) {

        return args -> {

            List<QuestionEntity> questionEntities = new ArrayList<>();

            QuestionEntity questionEntity1 = QuestionEntity.builder()
                    .question("What is the fastest animal ?\n 1. Turtle \n2. Giraffe \n3. Cheetah \n4. None of the above")
                    .rightAnswer(3)
                    .build();
            questionRepository.save(questionEntity1);


            questionEntities.add(questionEntity1);
            questionRepository.saveAll(questionEntities);


        };
    }
}
