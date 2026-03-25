package mylib.games.wordle;
import net.sf.extjwnl.dictionary.Dictionary;

import java.util.List;

public class Word {
    public static final int LENGTH = 5;
    public static final List<String> DICTIONARY = List.of("apple", "banana", "cherry");

    private String word;
    private List<LetterStatus> letterStatuses;

    public Word(String word, List<LetterStatus> letterStatuses) {
        assert word.length() == LENGTH && letterStatuses.size() == LENGTH;
        this.word = word;
        this.letterStatuses = letterStatuses;
    }

    public void addLetterStatus(LetterStatus letterStatuses) {
        this.letterStatuses.add(letterStatuses);
    }

    public String getWord() {
        return word;
    }

    public List<LetterStatus> getLetterStatuses() {
        return letterStatuses;
    }

    public List<String> getPossibleWords(){
        return DICTIONARY;
    }
}
