package org.accenture.complexity.secondLevel;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class RobotTest {
    private static final String[] DEFAULT_WORDS = new String[] {
            "thank", "you", "for", "teaching", "me", "i", "already", "know", "the", "word", "do", "not", "understand", "input"
    };

    private static final String[] BASE_WORDS = new String[] {
            "pippi", "hokuto", "yamato", "gankutsuou", "bubblegum", "crisis", "big", "o", "otogizoushi", "ghost", "in", "shell", "seirei", "moribito"
    };

    private static final char[] CHARS = new char[] { ' ', ',', '!', '?', '-', '^', '.', '%' };

    @Test
    public void completeTest() {
        Robot vicky = new Robot();
        assertEquals("Thank you for teaching me hello", vicky.learnWord("hello"));
        assertEquals("Thank you for teaching me world", vicky.learnWord("world"));
        assertEquals("Thank you for teaching me goodbye", vicky.learnWord("goodbye"));
        assertEquals("I already know the word world", vicky.learnWord("world"));
        assertEquals("I already know the word World", vicky.learnWord("World"));
        assertEquals("I already know the word thank", vicky.learnWord("thank"));
        assertEquals("I do not understand the input", vicky.learnWord("wow!"));
        assertEquals("I already know the word thank", vicky.learnWord("thank"));
        assertEquals("I already know the word you", vicky.learnWord("you"));
        assertEquals("I already know the word for", vicky.learnWord("for"));
        assertEquals("I already know the word teaching", vicky.learnWord("teaching"));
        assertEquals("I already know the word me", vicky.learnWord("me"));
        assertEquals("I already know the word I", vicky.learnWord("I"));
        assertEquals("I already know the word HELLO", vicky.learnWord("HELLO"));
        assertEquals("I do not understand the input", vicky.learnWord("a whole bunch of words"));
        assertEquals("I do not understand the input", vicky.learnWord("1234"));
        assertEquals("I do not understand the input", vicky.learnWord(" "));
        assertEquals("I do not understand the input", vicky.learnWord(""));
        assertEquals("I do not understand the input", vicky.learnWord("[]"));
        assertEquals("Thank you for teaching me sleep", vicky.learnWord("sleep"));
        assertEquals("Thank you for teaching me power", vicky.learnWord("power"));
        assertEquals("Thank you for teaching me CLOSET", vicky.learnWord("CLOSET"));
        assertEquals("I already know the word ALREADY", vicky.learnWord("ALREADY"));
        assertEquals("I already know the word KnOW", vicky.learnWord("KnOW"));
        assertEquals("I already know the word understand", vicky.learnWord("understand"));
    }

    @Test
    public void randomTests() {
        Random random = new Random();
        for (int n = 1; n <= 50; n++) {
            Robot vicky = new Robot();
            RobotClone vickyClone = new RobotClone();
            List<String> wordList = new ArrayList(10);
            for (int m = 1; m <= 10; m++)
                wordList.add(generateWord(random));
            for (String word : wordList)
                assertEquals(vickyClone.learnWord(word), vicky.learnWord(word));
        }
    }

    private String generateWord(Random random) {
        String base = random.nextInt(10) < 7 ? BASE_WORDS[random.nextInt(BASE_WORDS.length)] : DEFAULT_WORDS[random.nextInt(DEFAULT_WORDS.length)];
        StringBuilder wordBuilder = base.codePoints().map(c -> random.nextBoolean() ? Character.toUpperCase(c) : c).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
        if (random.nextInt(10) < 2)
            wordBuilder.insert(random.nextInt(wordBuilder.length()), CHARS[random.nextInt(CHARS.length)]);
        return wordBuilder.toString();
    }

    private static class RobotClone {
        private Set<String> words;

        public RobotClone() {
            words = new HashSet<>(Arrays.asList(RobotTest.DEFAULT_WORDS));
        }

        public String learnWord(String word) {
            if (word.matches("\\A[a-zA-Z]+\\z")) {
                return (words.add(word.toLowerCase()) ? "Thank you for teaching me " : "I already know the word ") + word;
            }
            return "I do not understand the input";
        }
    }
}
