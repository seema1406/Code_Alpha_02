import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineQuizPlatform {

    private static List<Question> questions = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeQuestions();

        while (true) {
            System.out.println("\nOnline Quiz Platform");
            System.out.println("1. Take Quiz");
            System.out.println("2. Add Question");
            System.out.println("3. View Results");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    takeQuiz();
                    break;
                case 2:
                    addQuestion();
                    break;
                case 3:
                    viewResults();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void initializeQuestions() {
        questions.add(new Question("What is the capital of France?", "Paris"));
        questions.add(new Question("What is 2 + 2?", "4"));
        questions.add(new Question("What is the largest planet in our solar system?", "Jupiter"));
    }

    private static void takeQuiz() {
        int score = 0;
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String answer = scanner.next();
            if (question.checkAnswer(answer)) {
                score++;
            }
        }
        System.out.println("Quiz completed! Your score: " + score + "/" + questions.size());
    }

    private static void addQuestion() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the question: ");
        String questionText = scanner.nextLine();
        System.out.print("Enter the answer: ");
        String answer = scanner.nextLine();
        questions.add(new Question(questionText, answer));
        System.out.println("Question added successfully!");
    }

    private static void viewResults() {
        System.out.println("\nQuestions:");
        for (Question question : questions) {
            System.out.println(question);
        }
    }
}

class Question {
    private String questionText;
    private String answer;

    public Question(String questionText, String answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public boolean checkAnswer(String providedAnswer) {
        return answer.equalsIgnoreCase(providedAnswer);
    }

    @Override
    public String toString() {
        return "Question: " + questionText + " | Answer: " + answer;
    }
}
