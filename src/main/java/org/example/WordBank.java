package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordBank {
    private final List<String> words = new ArrayList<>();
    private final Random random = new Random();

    public WordBank() {
        String wordsString = "ant baboon badger bat bear beaver camel cat clam cobra cougar " +
                "coyote crow deer dog donkey duck eagle ferret fox frog goat " +
                "goose hawk lion lizard llama mole monkey moose mouse mule newt " +
                "otter owl panda parrot pigeon python rabbit ram rat raven " +
                "rhino salmon seal shark sheep skunk sloth snake spider " +
                "stork swan tiger toad trout turkey turtle weasel whale wolf " +
                "wombat zebra";

        String[] wordArray = wordsString.split(" ");
        words.addAll(Arrays.asList(wordArray));
    }

    public void addWord(String word) {
        words.add(word);
    }

    public void removeWord(String word) {
        words.remove(word);
    }

    public String selectRandomWord() {
        if (words.isEmpty()) {
            System.out.println("There are no words currently available in the Word Bank");
            return null;
        }
        int randomIndex = random.nextInt(words.size());
        return words.get(randomIndex);
    }

    public int wordCount() {
        return words.size();
    }

    public void printAllWords(){
        for(String word:words){
            System.out.println(word);
        }
    }
}
