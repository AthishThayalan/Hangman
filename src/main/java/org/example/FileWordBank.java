package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FileWordBank extends WordBank {
    private Scanner reader;
    private final ArrayList<String> wordsFromFile;
    private final Random random;

    public FileWordBank() {
        super();
        wordsFromFile = new ArrayList<>();
        random = new Random();
        populateWordsFromFile();
    }

    public void populateWordsFromFile() {
        try {
            String fileName = "src/main/java/org/example/words.txt";
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            if (!reader.hasNext()) {
                System.out.println("The file is empty.");
                return;
            }
            while (reader.hasNext()) {
                String word = reader.next();
                wordsFromFile.add(word);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally{
            if (reader != null) {
                reader.close();
            }
        }
    }

    public void printWords(){
        System.out.println(wordsFromFile);
    }

    @Override
    public String selectRandomWord() {
        if (wordsFromFile.isEmpty()) {
            System.out.println("There are no words currently available in the Word Bank from the file");
            return null;
        }
        int randomIndex = random.nextInt(wordsFromFile.size());
        return wordsFromFile.get(randomIndex);
    }
}


