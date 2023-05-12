package org.hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private final List<String> words = List.of("car", "computer", "programming", "football");
    private String word;
    private char[] userWord;
    private int lives = 5;

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

            try {
                char letter = scanner.nextLine().charAt(0);
                checkLetter(letter);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please enter a single letter.");
            }
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
            lives--;
            System.out.println("Wrong letter. ");
            System.out.println("You have " + lives + " lives left.");
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
