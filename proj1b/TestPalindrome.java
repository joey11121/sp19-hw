import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void TestWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void TestIsPalindrome() {
        String s = "abcdeF";
        assertFalse("The test fails since isPalindrome should return true instead.", palindrome.isPalindrome(s));
        s = "abccba";
        assertTrue("The test fails since isPalindrome should return true instead.", palindrome.isPalindrome(s));
    }

    @Test
    public void secondTestIsPalindrome() {
        OffByOne test = new OffByOne();
        assertFalse("Overloaded isPalindrome should return true instead", palindrome.isPalindrome("abcddcba", test));
        assertTrue("Overloaded isPalindrome should return false instead", palindrome.isPalindrome("flake", test));

    }
}
