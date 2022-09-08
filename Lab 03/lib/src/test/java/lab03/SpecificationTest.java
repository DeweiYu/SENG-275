package lab03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class SpecificationTest {
    @ParameterizedTest(name = "x{0}, y{1}")
    @CsvSource({"0,1", "0,719", "1219,0", "1219,719"})
    void trueHD(int x, int y){
        Specification.setDefinition(0);
        assertTrue(Specification.insideDisplayArea(x,y));
    }

    @ParameterizedTest(name = "x{0}, y{1}")
    @CsvSource({"-1,0", "0,-1", "-1,-1", "719,-1", "0,720", "-1,720", "1280,720", "-1,720"})
    void falseHD(int x, int y){
        Specification.setDefinition(0);
        assertFalse(Specification.insideDisplayArea(x,y));
    }

    /**messageIsValid() Tests*/


    @ParameterizedTest(name = "input{0}, motorcycle{1}")
    @MethodSource("valPlates")
    void valPlates(String input, boolean motorcycle) {

        assertTrue(Specification.messageIsValid(input, motorcycle));
        //System.out.println(input);
    }

    private static Stream<Arguments> valPlates() {
        return Stream.of(
                Arguments.of("A1", true),
                Arguments.of("A12", false),
                Arguments.of("A1B1", false),
                Arguments.of("A1B1-C", false),
                Arguments.of("A1 B-1", false),
                Arguments.of("ABCCBA", true)
        );
    }


    @ParameterizedTest(name = "input{0}, motorcycle{1}")
    @MethodSource("invaldPlates")
    void invalPlates(String input, boolean motorcycle) {
        assertFalse(Specification.messageIsValid(input, motorcycle));
    }

    private static Stream<Arguments> invaldPlates() {
        return Stream.of(
                Arguments.of("42ACA6B", false),
                Arguments.of("123456", false),
                Arguments.of(" K  ", true),
                Arguments.of("k", false),
                Arguments.of("ootd- " ,false)


        );
    }
}