package com.example.lab2;



public class WordCounter{

    public static int getWordsCount(String enteredUserText){
        if (enteredUserText == null|| enteredUserText.isEmpty()) {
            return 0;
        }

        String[] text = enteredUserText.split("\\s+");
        return text.length;
    }
}