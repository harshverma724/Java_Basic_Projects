
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] questions = {
            "What is the capital of France?\n1. Berlin\n2. Madrid\n3. Paris\n4. Rome",
            "What is 5 + 3?\n1. 6\n2. 7\n3. 8\n4. 9"
        };

        int[] correctAnswers = {3, 3}; // Correct answers (indexed from 1)
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Choose your answer (1-4): ");
            int answer = scanner.nextInt();

            if (answer == correctAnswers[i]) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect.");
            }
        }

        System.out.println("\nYour final score: " + score + "/" + questions.length);
        scanner.close();
    }
}
