package org.example;

import java.util.HashSet;
import java.util.Set;

public class HangmanGame {
    private final int maxIncorrectGuesses = 8;
    private WordBank wordBank;
    private HangmanDisplay hangmanDisplay;
    private UserInput userInput;
    private String wordToGuess;
    private String guessedWord;
    private int incorrectGuesses;
    private int attempts;
    private boolean gameWon;
    private Set guessedLetters;


    public HangmanGame() {
        this.wordBank = new WordBank();
        this.hangmanDisplay = new HangmanDisplay();
        this.userInput = new UserInput();
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



    public void play(){
        hangmanDisplay.welcomeMessage();

        do {
            System.out.println("-----------------------------------------------");
            hangmanDisplay.displayHangman(incorrectGuesses);
            char guess = userInput.getUserGuess();

            System.out.println("The actual word to guess is: " + wordToGuess);
            if (!guessedLetters.contains(guess)) {
                this.attempts++;
                this.guessedLetters.add(guess);
                updateGuessedWord(guess);
                System.out.println("Guessed so far: " + guessedWord);
                if (!wordToGuess.contains(String.valueOf(guess))) incorrectGuesses++;
            } else {
                System.out.println("You've already guessed this letter. Please guess a different one.");
            }

            if (guessedWord.equals(wordToGuess)) {
                gameWon = true;
                break;

            }
        } while (incorrectGuesses < maxIncorrectGuesses && !gameWon);

        if(gameWon){
            System.out.println("Congratulations! You won ! It took you "+attempts+" attempts!");
        }else{
            System.out.println("Unlucky you lost. You had "+attempts+" attempts.");
        }
        boolean playAgain = userInput.playAgain();
        if(playAgain){
            resetGame();
            play();
        } else{
            System.out.println("Ahhh thats a shame , ok bye!");
        }


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

    private void resetGame() {
        wordToGuess = getRandomWord();
        guessedWord = wordsinDashes();
        incorrectGuesses = 0;
        attempts = 0;
        gameWon = false;
    }
}
