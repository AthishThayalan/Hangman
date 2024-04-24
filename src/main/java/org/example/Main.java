package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HangmanDisplay hangmanDisplay = new HangmanDisplay();

        System.out.println(hangmanDisplay.getSize());
        for(int i=0;i<8;i++){
            hangmanDisplay.displayHangman(i);
        }
    }}