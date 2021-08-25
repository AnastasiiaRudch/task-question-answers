package taskquestionanswers.task.dto;

import lombok.*;


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
