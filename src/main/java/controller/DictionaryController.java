package controller;

import Model.CustomDictionary;
import exception.WordNotFoundException;

public class DictionaryController {
    private CustomDictionary dictionary;

    public DictionaryController() {
        dictionary = new CustomDictionary();
        // Temporarily hardcode some words and meanings
        dictionary.addWord("Java", "A high-level programming language.");
        dictionary.addWord("Python", "An interpreted, high-level programming language.");
        dictionary.addWord("Algorithm", "A set of rules to solve a problem.");
        dictionary.addWord("Database", "A collection of organized data.");
    }

    // Method to search for a word and return its meaning
    public String searchWord(String word) {
        if (word == null || word.trim().isEmpty()) {
            return "Please enter a word to search.";
        }
        try {
            return dictionary.searchWord(word);
        } catch (WordNotFoundException e) {
            return e.getMessage();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
