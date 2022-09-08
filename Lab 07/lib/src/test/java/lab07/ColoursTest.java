package lab07;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import net.jqwik.api.*;
import net.jqwik.api.arbitraries.*;
import net.jqwik.api.constraints.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class ColoursTest {
    //all valid
    @Property
    void pass(@ForAll @IntRange(min = 0, max = 255) int r, @ForAll @IntRange(min = 0, max = 255) int b, @ForAll @IntRange(min = 0, max = 255) int g) {
        assertThat(Colours.rgbBytesToInt(r,b,g)).isEqualTo(r * 256 + b * 16 + g);
    }

    //red invalid
    @Property
    void invalidRed(@ForAll ("invalidRange") int r, @ForAll @IntRange(min = 0, max = 255) int b, @ForAll @IntRange(min = 0, max = 255) int g) {
        assertThrows(IllegalArgumentException.class, ()->Colours.rgbBytesToInt(r,b,g));
    }

    //Blue is invalid
    @Property
    void invalidBlue(@ForAll @IntRange(min = 0, max = 255) int r, @ForAll ("invalidRange") int b, @ForAll @IntRange(min = 0, max = 255) int g) {
        assertThrows(IllegalArgumentException.class, ()->Colours.rgbBytesToInt(r,b,g));
    }

    //Green is invalid
    @Property
    void invalidGreen(@ForAll @IntRange(min = 0, max = 255) int r, @ForAll @IntRange(min = 0, max = 255) int b, @ForAll ("invalidRange") int g) {
        assertThrows(IllegalArgumentException.class, ()->Colours.rgbBytesToInt(r,b,g));
    }

    // test case provides less than 0 or bigger than 255
    @Provide
    private Arbitrary<Integer> invalidRange(){
        return Arbitraries.oneOf(Arbitraries.integers().lessOrEqual(-1), Arbitraries.integers().greaterOrEqual(256));
    }

}