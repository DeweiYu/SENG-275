package lab04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class WordUtilitiesTest {
    @ParameterizedTest
    @MethodSource("generator")
    void swapCase(String description, String str, String expected){
        String result = WordUtilities.swapCase(str);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> generator(){
        return Stream.of(
                Arguments.of("empty string", "", ""),
                Arguments.of("contain only nulls", null, null),
                Arguments.of("contain only spaces", "  ", "  "),
                Arguments.of("contain only Upper letters", "MN", "mn"),
                Arguments.of("contain only lower letters", "de", "DE"),
                Arguments.of("Upper, space, lower", "E e", "e E"),
                Arguments.of("phrase with whitespace", "good morning", "GOOD MORNING"),
                Arguments.of("no space between upper & lower letter", "CuteCat", "cUTEcAT"),
                Arguments.of("spaces between upper case", "G O D", "g o d"),
                Arguments.of("sentence", "hello World", "HELLO wORLD")
        );
    }
}