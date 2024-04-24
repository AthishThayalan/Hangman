package org.example;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput(){
        this.scanner = new Scanner(System.in);
    }
    public char getUserGuess(){
        char guess;
        do {
            System.out.print("Enter your guess: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }
            guess = input.charAt(0);
            if (!Character.isLetter(guess)) {
                System.out.println("Please enter a valid letter.");
                continue;
            }
            break;
        } while (true);
        return guess;
    }
}
