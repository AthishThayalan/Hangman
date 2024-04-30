package org.example;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HangmanGame {
    private final int maxIncorrectGuesses = 8;
    private WordBank wordBank;
    private final HangmanDisplay hangmanDisplay;
    private final UserInput userInput;
    private String wordToGuess;
    private String guessedWord;
    private int incorrectGuesses;
    private int attempts;
    protected boolean gameWon;
    private Set guessedLetters;

    public HangmanGame() {
        this.wordBank = new WordBank();
        this.hangmanDisplay = new HangmanDisplay();
        this.userInput = new UserInput();
        chooseWordBank();
        this.wordToGuess = getRandomWord();
        this.guessedWord = wordsinDashes();
        this.incorrectGuesses = 0;
        this.attempts = 0;
        this.gameWon = false;
        this.guessedLetters = new HashSet();
    }

    private String getRandomWord(){
        return wordBank.selectRandomWord();
    }

    private String wordsinDashes(){
        return "_".repeat(wordToGuess.length());
    }
    private void chooseWordBank() {
        System.out.println("Do you want to use the normal word bank (type '1') or words from a text file (type '2')?");
        int choice = userInput.getIntInput();
        userInput.nextLine();
        if (choice == 1) {
            this.wordBank = new WordBank();
        } else if (choice == 2) {
            this.wordBank = new FileWordBank();
        } else {
            System.out.println("Invalid choice. Using normal word bank by default.");
            this.wordBank = new WordBank();
        }
    }

    public void play(){
        hangmanDisplay.welcomeMessage();
        do {
            System.out.println("-----------------------------------------------");
            hangmanDisplay.displayHangman(incorrectGuesses);
            System.out.println("The actual word to guess is: " + wordToGuess);
            System.out.println("Guessed so far : " + guessedWord);
            char guess = userInput.getUserGuess();
            handleGuess(guess);
        } while (incorrectGuesses < maxIncorrectGuesses && !gameWon);

        handleGameOutcome();
    }

    private void handleGuess(char guess){
        if (!guessedLetters.contains(guess)) {
            this.attempts++;
            this.guessedLetters.add(guess);
            updateGuessedWord(guess);

            if (!wordToGuess.contains(String.valueOf(guess))) incorrectGuesses++;
        } else {
            System.out.println("You've already guessed this letter. Please guess a different one.");
        }

        if (guessedWord.equals(wordToGuess)) {
            System.out.println("Nice one ! You guessed '" + guessedWord+ "' correctly!");
            gameWon = true;
        }
    }

    protected boolean isGameOver(){
        return incorrectGuesses >= maxIncorrectGuesses || guessedWord.equals(wordToGuess);
    }

    protected void handleGameOutcome() {
        if (gameWon) {
            System.out.println("Congratulations! You won ! It took you " + attempts + " attempts! And you had " + (this.incorrectGuesses == 0 ? "no incorrect guesses!" : this.incorrectGuesses + " incorrect guesses!"));
        } else {
            System.out.println("Unlucky you lost. You had "+attempts+" attempts.");
        }
        boolean playAgain = userInput.playAgain();
        restartGame(playAgain);
    }

    private void updateGuessedWord(char guess) {
        StringBuilder updatedWord = new StringBuilder(guessedWord);
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                updatedWord.setCharAt(i , guess);
            }
        }
        guessedWord = updatedWord.toString();
    }

    protected void resetGame() {
        wordToGuess = getRandomWord();
        guessedWord = wordsinDashes();
        incorrectGuesses = 0;
        attempts = 0;
        gameWon = false;
        guessedLetters = new HashSet<>();
    }

    protected void restartGame(boolean playAgain){
        if (playAgain) {
            resetGame();
            play();
        } else {
            System.out.println("Ahhh thats a shame , ok bye!");
        }
    }
}
