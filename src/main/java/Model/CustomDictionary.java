package Model;
import exception.WordNotFoundException;

import java.util.HashMap;

public class CustomDictionary {
    private HashMap<String, String> wordMap;

    public CustomDictionary() {
        wordMap = new HashMap<>();
    }

    // Method to add a word and its meaning to the dictionary
    public void addWord(String word, String meaning) {
        if (word != null && !word.trim().isEmpty()) {
            wordMap.put(word.toLowerCase(), meaning);
        }
    }

    // Method to search for a word and retrieve its meaning
    public String searchWord(String word) throws WordNotFoundException {
        if (word == null || word.trim().isEmpty()) {
            throw new IllegalArgumentException("Word cannot be empty.");
        }
        String meaning = wordMap.get(word.toLowerCase());
        if (meaning == null) {
            throw new WordNotFoundException("Word not found in the dictionary.");
        }
        return meaning;
    }
}
