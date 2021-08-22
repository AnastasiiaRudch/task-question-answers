package taskquestionanswers.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskquestionanswers.task.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
}
