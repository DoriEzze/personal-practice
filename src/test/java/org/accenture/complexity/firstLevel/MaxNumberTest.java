package org.accenture.complexity.firstLevel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MaxNumberTest {
    private static final Logger logger = Logger.getLogger(MaxNumberTest.class.getName());

    // Adjust as needed
    public static final double MAX_EXECUTION_TIME_MS = 5;
    public static final int MAX_WAIT_TIME_LOOP_IN_SEC = 10;

    public static String concatenateCharacters(List<Character> charList) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : charList) {
            sb.append(ch);
        }
        return sb.toString();
    }

    @Test
    public void testFunctionTimePerformance() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        long beforeWarmup = System.currentTimeMillis();
        // warmup of CPU cache
        for (int i = 0; i < 200; i++) {
            MaxNumber.print(random.nextLong(0, Long.MAX_VALUE / 10));
        }
        long afterWarmup = System.currentTimeMillis();
        double warmupTimeSec = (afterWarmup - beforeWarmup) / 1_000D;
        assertTrue("Rough execution time is too high: "
                + String.format("%.1f", warmupTimeSec * 5) + "ms", warmupTimeSec < MAX_WAIT_TIME_LOOP_IN_SEC);    // factor of 5 is due to 1000 (ms/s) / 200 iterations

        long startTime = System.nanoTime();
        int iterations = 10_000;
        // ------
        for (int i = 0; i < iterations; i++) {
            MaxNumber.print(random.nextLong(0, Long.MAX_VALUE / 10));
        }
        // ------
        long endTime = System.nanoTime();

        // Calculate the execution time in milliseconds
        long totalExecutionTimeMs = (endTime - startTime) / 1_000_000;
        double avgExecTimeMs = totalExecutionTimeMs / (double) iterations;
        logger.info("Average execution time was: " + String.format("%.3f", avgExecTimeMs) + "ms");
        assertTrue("Execution time exceeded the " + MAX_EXECUTION_TIME_MS + "ms limit", avgExecTimeMs <= MAX_EXECUTION_TIME_MS);
    }

    @Test
    public void testRandomValues() {
        char[] almostAllDigits = new char[]{'0', '0', '1', '2', '2', '3', '3', '3', '4', '5', '6', '7', '7', '8', '8', '9', '9'};

        for (int i = 0; i < 100; i++) {
            List<Character> allDigitList = new ArrayList<>();
            for (char digit : almostAllDigits) {
                allDigitList.add(digit);
            }
            Collections.shuffle(allDigitList);
            allDigitList.add(0, '1');   // to prevent starting with 0
            String shuffledDigits = concatenateCharacters(allDigitList);
            long randomNumber = Long.parseLong(shuffledDigits);

            long actualMaxNumber = MaxNumber.print(randomNumber);

            long expectedMaxNumber = 998877654333221100L;  // allMostAllDigits joined with {'1'}, in descending order
            assertEquals("Expected: " + expectedMaxNumber + " from " + randomNumber + ", but got: " + actualMaxNumber, expectedMaxNumber, actualMaxNumber);
        }
    }
}
