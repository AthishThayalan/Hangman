package org.example;
import java.util.Timer;
import java.util.TimerTask;

public class TimedHangmanGame extends HangmanGame {

    private Timer timer;
    private final int TIME_LIMIT = 2;
    private int timeRemaining;

    public TimedHangmanGame(){
        super();
        this.timer = new Timer();
        this.timeRemaining = TIME_LIMIT;
    }

    public void resetTimer() {
        timer.cancel();
        timer = new Timer();
        this.timeRemaining = TIME_LIMIT;
        startTimer();

    }

    private void startTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!gameWon && timeRemaining > 0) {
                    timeRemaining--;
                } else {
                    timer.cancel();
                    if (!gameWon) {
                        System.out.println("Time's up! You ran out of time! The word was '"+wordToGuess+"'");
                    }
                }
            }
        }, 1000, 1000);

    }


    @Override
    public void play() {
        System.out.println("You have "+TIME_LIMIT+" seconds to guess the word! GOOD LUCK");
        startTimer();
        super.play();
    }



    @Override
    protected void resetGame() {
        super.resetGame();
        this.resetTimer();
    }
}
