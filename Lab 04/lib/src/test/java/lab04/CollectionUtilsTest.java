package lab04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class CollectionUtilsTest {


    @Test
    void sameSize(){
        Collection C1 = new ArrayList();
        C1.add("a");
        C1.add("s");
        C1.add("c");
        C1.add("d");
        C1.add("f");

        Collection C2 = new ArrayList();
        C2.add("x");
        C2.add("y");
        C2.add("z");
        C2.add("a");
        C2.add("n");

        assertTrue(CollectionUtils.containsAny(C1, C2));
    }

    @Test
    void NotSameSizeMultiple(){
        Collection C1 = new ArrayList();
        C1.add("a");
        C1.add("b");
        C1.add("c");
        C1.add("d");

        Collection C2 = new ArrayList();
        C2.add("a");
        C2.add("a");
        C2.add("b");
        C2.add("c");
        C2.add("d");

        assertTrue(CollectionUtils.containsAny(C1, C2));
    }

    @Test
    void emPtyMultiple(){
        Collection C1 = new ArrayList();
        C1.add(" ");


        Collection C2 = new ArrayList();
        C2.add("a");
        C2.add("a");
        C2.add("a");

        assertFalse(CollectionUtils.containsAny(C1, C2));
    }

    @Test
    void secondWEmptyMultiple(){
        Collection C1 = new ArrayList();
        C1.add("a");
        C1.add("a");
        C1.add("a");


        Collection C2 = new ArrayList();
        C2.add(" ");


        assertFalse(CollectionUtils.containsAny(C1, C2));
    }

//    @ParameterizedTests
//    @MethodSource("generator")
//    void containsAny(String match, final Collection<?> coll1, final Collection<?> coll2) {
//        boolean result = CollectionUtils.containsAny(coll1,coll2);
//        assertTrue(expected, result);
//    }
//
//    private static Stream<Arguments> generator(){
//        return Stream.of(Arguments.of("collection is empty", null,0,0)),
//        Arguments
//    }
}