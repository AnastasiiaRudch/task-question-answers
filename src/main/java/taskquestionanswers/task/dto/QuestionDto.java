package taskquestionanswers.task.dto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class QuestionDto {

    private int id;
    private String question;
    private Integer rightAnswer;

}
