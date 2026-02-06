package com.rimonmostafiz.javacollections.exercises.set;

import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

// Implement the VocabularyWordManager using a SortedSet internally

public class VocabularyWordManager {

    SortedSet<String> sortedSet;

    public VocabularyWordManager(Collection<String> words) {
        this.sortedSet = new TreeSet<>(words);
    }

    public String getFirstWord() {
        return this.sortedSet.getFirst();
    }

    public String getLastWord() {
        return this.sortedSet.getLast();
    }

    public SortedSet<String> getWordsBefore(String word) {
        return this.sortedSet.headSet(word);
    }

    public SortedSet<String> getWordsAfter(String word) {
        SortedSet<String> tailSet = this.sortedSet.tailSet(word);
        String s = tailSet.removeFirst();
        return tailSet;
    }

    public SortedSet<String> getWordsBetween(String startWord, String endWord) {
        SortedSet<String> strings = this.sortedSet.subSet(startWord, endWord);
        strings.removeFirst();
        return strings;
    }

    public static void main(String[] args) {
        VocabularyWordManager vocab = new VocabularyWordManager(
                Set.of("apple",
                        "banana",
                        "carrot",
                        "date",
                        "eggplant",
                        "fig",
                        "grape",
                        "honey"));

        System.out.println("First word: " + vocab.getFirstWord());
        System.out.println("Last word: " + vocab.getLastWord());

        String targetWord = "eggplant";
        SortedSet<String> wordsBefore = vocab.getWordsBefore(targetWord);
        System.out.println("Words before " + targetWord + ": " + wordsBefore);

        SortedSet<String> wordsAfter = vocab.getWordsAfter(targetWord);
        System.out.println("Words after " + targetWord + ": " + wordsAfter);

        String startWord = "carrot";
        String endWord = "grape";
        SortedSet<String> wordsBetween = vocab.getWordsBetween(startWord, endWord);
        System.out.println("Words between " + startWord + " and " + endWord + ": " + wordsBetween);
    }
}
