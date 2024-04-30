package org.example;
import java.util.Timer;
import java.util.TimerTask;


public class TimedHangmanGame extends HangmanGame {
    private Timer timer;
    private final int TIME_LIMIT = 3;
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
                    System.out.println(timeRemaining);
                    timeRemaining--;
                } else {
                    timer.cancel();
                    if(!gameWon){
                        System.out.println("Times up! You ran out of time!");
                        handleGameOutcome();
                    }
                }
            }
        }, 1000, 1000);
    }

    @Override
    public void play() {
        startTimer();
        super.play();
    }

    @Override
    protected boolean isGameOver() {
        return super.isGameOver() || timeRemaining==0;
    }

    @Override
    protected void resetGame() {
        super.resetGame();
        this.resetTimer();
    }
}
