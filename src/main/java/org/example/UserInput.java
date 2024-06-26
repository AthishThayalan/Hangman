package org.example;

import java.util.Scanner;

public class UserInput {
    public   Scanner scanner;

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

    public boolean playAgainInput() {
        System.out.print("Do you want to play again? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y");
    }

    public int getIntInput() {
        int value;
        do {
            System.out.println("Please enter 1 or 2:");
            value = scanner.nextInt();
        } while (value != 1 && value != 2);

        return value;
    }

    public void nextLine() {
        scanner.nextLine();
    }
    public void closeScanner() {
        scanner.close();
    }
}
