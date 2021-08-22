package taskquestionanswers.task;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import taskquestionanswers.task.entity.QuestionEntity;
import taskquestionanswers.task.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class TaskQuestionAnswersApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskQuestionAnswersApplication.class, args);
    }

    @Bean
    CommandLineRunner init(QuestionRepository questionRepository) {

        return args -> {

//            List<QuestionEntity> questionEntities = new ArrayList<>();
//            List<String> answersForQ1 = new ArrayList<>();
//            String answer1 = "15";
//            String answer2 = "16";
//            String answer3 = "17";
//            String answer4 = "18";
//            answersForQ1.add(answer1);
//            answersForQ1.add(answer2);
//            answersForQ1.add(answer3);
//            answersForQ1.add(answer4);
//
//            QuestionEntity questionEntity1 = QuestionEntity.builder()
//                    .question("12 + 4")
//                    .answers(answersForQ1)
//                    .rightAnswer(answer2)
//                    .build();
//            questionRepository.save(questionEntity1);
//
//
//            questionEntities.add(questionEntity1);
//            questionRepository.saveAll(questionEntities);

            Faker faker = new Faker();

            for (int i = 0; i < 10; i++) {
                QuestionEntity entity = new QuestionEntity();
                entity.setQuestion("What is " + faker.gameOfThrones().quote() + " mean?");
                List<String> answers = new ArrayList<>();
                answers.add(faker.gameOfThrones().city());
                answers.add(faker.gameOfThrones().city());
                answers.add(faker.gameOfThrones().city());
                answers.add(faker.gameOfThrones().city());
                entity.setAnswers(answers);
                entity.setRightAnswer(answers.get(faker.random().nextInt(answers.size())));
                questionRepository.save(entity);
            }

        };
    }
}
