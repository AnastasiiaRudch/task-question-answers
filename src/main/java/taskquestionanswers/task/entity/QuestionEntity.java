package taskquestionanswers.task.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity

public class QuestionEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @NonNull
    @Column(name = "question", unique = true)
    private String question;

    @NonNull
    @Column(name = "rightAnswer")
    private Integer rightAnswer;

}
