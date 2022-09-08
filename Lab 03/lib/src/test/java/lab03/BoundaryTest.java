package lab03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BoundaryTest {

    @Test
    void isUnsafe() {assertTrue(Boundary.isUnsafe(86));}

    @Test
    void isNotUnsafe() {assertFalse(Boundary.isUnsafe(85));}

    @ParameterizedTest
    @ValueSource(ints = {5,10,20})
    void isComfortable(int temperature) {

        assertTrue(Boundary.isComfortable(temperature));
    }

    @ParameterizedTest
    @ValueSource(ints = {3,25})
    void isComfory(int temperature) {

        assertFalse(Boundary.isComfortable(temperature));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0})
    void elevatorRequired(int storeys) {

        assertEquals(Boundary.elevatorsRequired(storeys), 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {3,5})
    void eRequired(int storeys) {

        assertEquals(Boundary.elevatorsRequired(storeys), 1);
    }

    @ParameterizedTest
    @ValueSource(doubles = {35,45,49})
    void percentageToLetterGrade(double percent) {

        assertEquals("F", Boundary.percentageToLetterGrade(percent));
    }

    @ParameterizedTest
    @ValueSource(doubles = {51,54,59})
    void percentageToLetterGrad(double grade) {

        assertEquals("D", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {61,63,64})
    void percentageToLetterGra(double grade) {

        assertEquals("C", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {66,67,69})
    void percentageToLetterGr(double grade) {

        assertEquals("C+", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {71,72})
    void perToLetter(double grade) {

        assertEquals("B-", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {74,75,76})
    void perToLettergrade(double grade) {

        assertEquals("B", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {78,79})
    void perToLettergradeNum(double grade) {

        assertEquals("B+", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {83,82})
    void perToLradeNum(double grade) {

        assertEquals("A-", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {86,87})
    void perToNum(double grade) {
        assertEquals("A", Boundary.percentageToLetterGrade(grade));
    }

    @ParameterizedTest
    @ValueSource(doubles = {94,95,97})
    void perToLetterGrades(double grade) {
        assertEquals("A+", Boundary.percentageToLetterGrade(grade));
    }
}
