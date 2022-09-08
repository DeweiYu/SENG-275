package lab07;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.*;
import org.junit.jupiter.api.Test;

class PalindromeTest {

    /*
     * Try testing the following cases:
     *  - any string, followed by the reverse of that string is a palindrome.
     *  - any string, followed by a single character, then the reverse of the string is a palindrome.
     *  - Any string made up of unique characters of length 2 or greater is not a palindrome.
     *  - Any palindrome set to uppercase is still a palindrome.
     */

    @Property
    void stringPlusReverse(@ForAll @AlphaChars String str){
        assertTrue(Palindrome.isPalindrome(str+reverse(str)));
    }
    @Property
    void stringPlusCharaPlusString(@ForAll @AlphaChars String str,@ForAll @AlphaChars char letter){
        assertTrue(Palindrome.isPalindrome(str+letter+reverse(str)));
    }

    @Property
    void UpperString(@ForAll @UpperChars String str, @ForAll @AlphaChars char letter){
        assertTrue(Palindrome.isPalindrome(str+letter+reverse(str)));
    }

    @Property
    void UniqueString(@ForAll @UpperChars @UniqueElements @Size(min=2) char[] character){
        String str = String.valueOf(character);
        assertFalse(Palindrome.isPalindrome(str));

    }

    @Test
    void nullString(){
        assertThrows(IllegalArgumentException.class, ()->Palindrome.isPalindrome(null));
    }

    static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
}