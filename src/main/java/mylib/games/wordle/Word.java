package mylib.games.wordle;
import edu.mit.jwi.Dictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.POS;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Getter
@Setter
public class Word {
    public static final int LENGTH = 5;
    public static final Set<String> DICTIONARY = getDictionary();

    private String word;
    private List<LetterStatus> letterStatuses;

    public Word(String word, List<LetterStatus> letterStatuses) {
        assert word.length() == LENGTH && letterStatuses.size() == LENGTH;
        assert DICTIONARY.contains(word);
        this.word = word;
        this.letterStatuses = letterStatuses;
    }

    public void addLetterStatus(LetterStatus letterStatuses) {
        this.letterStatuses.add(letterStatuses);
    }

    public static List<String> getPossibleWords(Word... words){
        List<String> possibleWords = new ArrayList<>(DICTIONARY);
        for(Word word: words){
            for(int i = 0; i < LENGTH; i++){
                int finalI = i;
                char c = word.word.charAt(finalI);
                possibleWords = switch(word.getLetterStatuses().get(i)){
                    case WRONG -> possibleWords.stream().filter(w -> !w.contains(""+ c)).toList();
                    case CORRECT -> possibleWords.stream().filter(w -> w.charAt(finalI) == c).toList();
                    case EXISTS -> possibleWords.stream().filter(w -> w.contains(""+ c)).toList();
                };
            }
        }
        return possibleWords;
    }

    private static Set<String> getDictionary() {
        File dictFolder = new File("/home/panos/Documents/Java Projects/MyLibrary/WordNet-3.0.tar.gz");
        Dictionary dict = new Dictionary(dictFolder);
        try {
            dict.open();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Iterator<IIndexWord> iterator = dict.getIndexWordIterator(POS.NOUN);
        Set<String> wordList = new HashSet<>();
        while (iterator.hasNext()) {
            IIndexWord indexWord = iterator.next();
            String lemma = indexWord.getLemma();
            if(lemma.length() == LENGTH) {
                wordList.add(lemma);
            }
        }
        return wordList;
    }
}
