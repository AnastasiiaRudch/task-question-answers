package taskquestionanswers.task.entity;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "question")
    private String question;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> answers = new ArrayList<>();

    @NonNull
    @Column(name = "rightAnswer")
    private String rightAnswer;

}
