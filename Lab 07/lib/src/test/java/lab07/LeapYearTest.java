
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

class LeapYearTest {

    //TEST CASE FOR leap year
    @Property
    void validLeapYearFor400(@ForAll("leapYear400") int year){
        assertTrue(LeapYear.isLeapYear(year));
    }
    @Provide
    private Arbitrary <Integer> leapYear400(){
        return Arbitraries.integers()
                .filter(n -> n > 0)
                .filter(n -> n% 400 == 0);

    }

    //Test case for divisible by 4
    @Property
    void validLeapYearFor4(@ForAll("leapYear4") int year){
        assertTrue(LeapYear.isLeapYear(year));
    }
    @Provide
    private Arbitrary <Integer> leapYear4(){
        return Arbitraries.integers()
                .filter(n -> n % 4 == 0)
                .filter(n -> n >= 1 )
                .filter(n -> n % 400 != 0)
                .filter(n -> n % 100 != 0);
    }

    // test case smaller than 1
    @Property
    void invalidLeapYear(@ForAll("invalidLeapYear") int year){
        assertThrows(IllegalArgumentException.class, ()->LeapYear.isLeapYear(year));
    }
    @Provide
    private Arbitrary <Integer> invalidLeapYear(){
        return Arbitraries.integers().filter(n -> n < 1);
    }

    //test case for only multiple of 100
    @Property
    void invalidLeapYearFor100(@ForAll("invalidLeapYearFor100") int year){
        assertFalse(LeapYear.isLeapYear(year));
    }
    @Provide
    private Arbitrary <Integer> invalidLeapYearFor100(){
        return Arbitraries.integers()
                .filter(n -> n >= 1 )
                .filter(n -> n % 400 != 0)
                .filter(n -> n % 100 == 0);
    }

    //test case for not multiple of 100 or 400
    @Property
    void neither100nor400 (@ForAll("neither100nor400") int year){
        assertFalse(LeapYear.isLeapYear(year));
    }
    @Provide
    private Arbitrary <Integer> neither100nor400(){
        return Arbitraries.integers()
                .filter(n -> n >= 0 )
                .filter(n -> n % 4 != 0)
                .filter(n -> n % 400 != 0)
                .filter(n -> n % 100 != 0);
    }

}