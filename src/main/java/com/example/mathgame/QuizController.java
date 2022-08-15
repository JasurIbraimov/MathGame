package com.example.mathgame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import java.util.Timer;
import java.util.TimerTask;

public class QuizController {
    char sign;
    int right = 0, wrong = 0, timer = 60;
    Quiz currentQuiz;
    @FXML
    private Button confirmBtn;

    @FXML
    private Text quizText;

    @FXML
    private TextField userInput;

    @FXML
    private Text rightText;

    @FXML
    private Text timerText;

    @FXML
    private Text wrongText;

    @FXML
    void initialize() {
        next_quiz();
        Timer timer = new Timer();
        TimerTask task = new TimerTask()
        {
            public void run()
            {
                //The task you want to do
                System.out.println("Hello World");
            }

            @Override
            public long scheduledExecutionTime() {

                return super.scheduledExecutionTime();
            }
        };
        timer.schedule(task, 5000L);
        confirmBtn.setOnAction(event -> {
            checkUserAnswer();
        });

    }
    void checkUserAnswer() {
        if (!userInput.getText().equals("")) {
            try {
                int userAnswer = Integer.parseInt(userInput.getText());
                if (userAnswer == currentQuiz.getAnswer()) {
                    rightText.setText("Right: " + ++right);
                } else {
                    wrongText.setText("Wrong: " + ++wrong);
                }
                next_quiz();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    int getRandomNumber() {
        return (int) (Math.random() * 100 + 1);
    }
    void setSign(char s) {
        sign = s;
    }

    void next_quiz() {
        currentQuiz = new_quiz(sign);
        quizText.setText(currentQuiz.getQuestion());
        userInput.setText("");
    }
    Quiz new_quiz(char s) {
        int firstNumber = getRandomNumber();
        int secondNumber = getRandomNumber();
        String question =  firstNumber + " " + s  + " " + secondNumber + " = ?";
        int answer;
        switch (s) {
            case '+':
                answer = firstNumber + secondNumber;
                break;

            case '-':
                answer = firstNumber - secondNumber;
                break;

            case ':':
                answer = firstNumber / secondNumber;
                break;

            default:
                answer = firstNumber * secondNumber;
                break;
        }
        return new Quiz(question, answer);
    }
}


final class Quiz {
    private final String question;
    private final int answer;

    public Quiz(String question, int answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }
}