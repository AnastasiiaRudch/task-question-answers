package taskquestionanswers.task.exceptions;

public class QuestionIsAlreadyExistException extends RuntimeException{

    public QuestionIsAlreadyExistException() {
        super();
    }

    public QuestionIsAlreadyExistException(String message) {
        super(message);
    }

    public QuestionIsAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionIsAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
