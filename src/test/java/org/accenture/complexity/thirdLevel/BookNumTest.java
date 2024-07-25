package org.accenture.complexity.thirdLevel;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BookNumTest {
    @Test
    public void testFour() {
        assertEquals(4, BookNum.pageDigits(4));
    }

    @Test
    public void testTwelve() {
        assertEquals(15, BookNum.pageDigits(12));
    }

    @Test
    public void testOneHundred() {
        assertEquals(192, BookNum.pageDigits(100));
    }

    @Test
    public void testHuge1() {
        assertEquals(7088888888888888907L, BookNum.pageDigits(400000000000000000L));
    }

    @Test
    public void testHuge2() {
        assertEquals(5428894021529291739L, BookNum.pageDigits(307778062924466824L));
    }

    private static long reference(long pages) {
        long mul = 1;
        long cnt = 1;
        long total = 0;
        while (pages / mul >= 10) {
            total += 9 * mul * cnt;
            mul *= 10;
            cnt++;
        }
        total += (pages - mul + 1) * cnt;
        return total;
    }

    Random random = new Random();

    @Test
    public void smallRandomTests() {
        for(int i = 0; i < 100; i++) {
            long n = random.nextInt(10_000) + 1;
            assertEquals(reference(n), BookNum.pageDigits(n));
        }
    }

    @Test
    public void bigRandomTests() {
        for(int i = 0; i < 100; i++) {
            long n = random.nextInt(9) + 1;
            for (int j = random.nextInt(17); j > 0; j--) n = n * 10 + random.nextInt(10);
            assertEquals(reference(n), BookNum.pageDigits(n));
        }
    }
}
