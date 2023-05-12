package org.hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    List<String> words = List.of("car", "computer", "programming", "football");
    String word;
    char[] userWord;
    int lives = 5;

    public void play() {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        word = words.get(random.nextInt(words.size()));

        userWord = new char[word.length()];
        Arrays.fill(userWord, '_');

        while (!gameEnded()) {
            System.out.println(userWord);
            System.out.println();
            System.out.println("Provide a letter: ");

            char letter = scanner.nextLine().charAt(0);

            checkLetter(letter);

            //add function to check correctly answers from user
        }
        scanner.close();
    }

    private void checkLetter(char letter) {
        boolean foundLetter = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                userWord[i] = letter;
                foundLetter = true;
            }
        }
        if (!foundLetter) {
            System.out.println("Wrong letter :( ");
            int live = lives--;
            System.out.println("You have " + live + " lives left");
            System.out.println("============================"+ "\n");
        }
    }

    private boolean gameEnded() {

        if (lives == 0) {
            System.out.println("You lost. Try next time!");
            return true;
        } else if (word.equals(String.valueOf(userWord))) {
            System.out.println("Congratulation! You won!");
            return true;
        } else {
            return false;
        }
    }
}
