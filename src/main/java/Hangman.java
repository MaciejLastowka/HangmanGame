import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    List<String> words = List.of("car", "computer", "programming", "football");
    String word;
    char[] userWord;

    public void play() {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        word = words.get(random.nextInt(words.size()));

        userWord = new char[word.length()];
        Arrays.fill(userWord, '_');

        System.out.println(userWord);

        while (!gameEnded()) {
            System.out.println(userWord);
            System.out.println();
            System.out.println("Podaj litere");

            char letter = scanner.nextLine().charAt(0);

            checkLetter(letter);

            //add function to check correctly answers from user
        }
        scanner.close();
    }

    private void checkLetter(char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                userWord[i] = letter;
            }
        }
    }

    private boolean gameEnded() {
        return false;
    }
}
