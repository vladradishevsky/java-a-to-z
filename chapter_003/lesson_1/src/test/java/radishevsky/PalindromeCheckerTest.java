package radishevsky;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Vladislav on 30.12.2016.
 */
public class PalindromeCheckerTest {

    @Test(expected = Exception.class)
    public void whenWordMore5charsThenThrowExc() throws Exception {
        PalindromeChecker pc = new PalindromeChecker();
        boolean result = pc.checkPalindrome("123456");

    }

    @Test(expected = Exception.class)
    public void whenWordIsEmptyThenThrowExc() throws Exception {
        PalindromeChecker pc = new PalindromeChecker();
        boolean result = pc.checkPalindrome("");

    }

    @Test
    public void whenWordIsPalindromeThenReturnTrue() throws Exception {
        PalindromeChecker pc = new PalindromeChecker();
        boolean result = pc.checkPalindrome("12321");

        assertThat(result, is(true));
    }

    @Test
    public void whenWordHasDifferentCaseAndItIsPalindromeThenReturnTrue() throws Exception {
        PalindromeChecker pc = new PalindromeChecker();
        boolean result = pc.checkPalindrome("ABсba");

        assertThat(result, is(true));
    }

    @Test
    public void whenWordIsNotPalindromeThenReturnFalse() throws Exception {
        PalindromeChecker pc = new PalindromeChecker();
        boolean result = pc.checkPalindrome("abcde");

        assertThat(result, is(false));
    }
}