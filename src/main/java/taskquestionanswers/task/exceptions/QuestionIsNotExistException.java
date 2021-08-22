package taskquestionanswers.task.exceptions;

public class QuestionIsNotExistException extends RuntimeException{
    public QuestionIsNotExistException() {
        super();
    }

    public QuestionIsNotExistException(String message) {
        super(message);
    }

    public QuestionIsNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionIsNotExistException(Throwable cause) {
        super(cause);
    }
}
