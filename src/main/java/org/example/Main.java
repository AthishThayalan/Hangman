package org.example;

import java.sql.Time;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        System.out.println("Choose a game type:");
        System.out.println("1. Normal Hangman");
        System.out.println("2. Timed Hangman");
        int choice = userInput.getIntInput();
        switch (choice) {
            case 1:
                HangmanGame normalGame = new HangmanGame();
                normalGame.play();
                break;
            case 2:
                TimedHangmanGame timedGame = new TimedHangmanGame();
                timedGame.play();

            default:
                System.out.println("Exiting...");
                break;
        }


    }}