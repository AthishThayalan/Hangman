package org.example;

public class HangmanGame {
    private WordBank wordBank;
    private HangmanDisplay hangmanDisplay;
    private UserInput userInput;
    private String wordToGuess;
    private String guessedWord;
    private int incorrectGuesses;
    private final int maxIncorrectGuesses = 8;

    public HangmanGame() {
        this.wordBank = new WordBank();
        this.hangmanDisplay = new HangmanDisplay();
        this.userInput = new UserInput();
        this.wordToGuess = getRandomWord();
        this.guessedWord = wordsinDashes();
        this.incorrectGuesses = 0;
    }

    private String getRandomWord(){
        return wordBank.selectRandomWord();
    }

    private String wordsinDashes(){
        return "*".repeat(wordToGuess.length());
    }

    public void play(){
        System.out.println("Welcome to my Hangman game!");
        System.out.println("All you gotta do is guess the word: ");

        do {
            char guess = userInput.getUserGuess();
            hangmanDisplay.displayHangman(incorrectGuesses);
            System.out.println("The actual word to guess is: " + wordToGuess);
            System.out.println("Guessed so far: " + guessedWord);

            if (wordToGuess.contains(String.valueOf(guess))) {
                System.out.println("Wheyyyyy you guessed correct. " + guess + " is in the word to guess");
            } else {
                System.out.println("No Unfortunately that is wrong.");
                incorrectGuesses++;
            }
        } while (incorrectGuesses < maxIncorrectGuesses);


    }
}
