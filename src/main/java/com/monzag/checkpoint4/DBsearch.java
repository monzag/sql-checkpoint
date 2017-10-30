package com.monzag.checkpoint4;

import java.util.Scanner;

public class DBsearch {

    public DBsearch() {

    }

    public void run() {
        String phrase = getPhrase();

    }

    public String getPhrase() {
        String userInput;

        System.out.println("\nSearch phrase: ");
        userInput = new Scanner(System.in).nextLine();
        return userInput;
    }
}
