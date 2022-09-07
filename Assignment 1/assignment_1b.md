**Question 1**  
I1 = { 1 ≤ x ≤ 100 and 1 ≤ y ≤ 100 and 1 ≤ z ≤ 100 } (All inputs are valid)  
I2 = { 15 ≤ x ≤ 100 and 15 ≤ y ≤ 100 and z ≤1} (x is valid, y is valid, z is not valid)  
I3 = { 10 ≤ x ≤ 300 and 10 ≤ y ≤ 300 and 10 ≤ z ≤ 300 } (All inputs are valid)  
I4 = { 20 ≤ x ≤ 300 and 20 ≤ y ≤ 300 and 20 ≤ z ≤ 300 } (All inputs are valid)  
I5 = { 30 ≤ x ≤ 300 and 30 ≤ y ≤ 300 and 30 ≤ z ≤ 300 } (All inputs are valid)  
I6 = { 40 ≤ x ≤ 300 and 40 ≤ y ≤ 300 and 40 ≤ z ≤ 300 } (All inputs are valid)  
I7 = { 50 ≤ x ≤ 300 and 50 ≤ y ≤ 300 and 50 ≤ z ≤ 300 } (All inputs are valid)  
I8 = { 60 ≤ x ≤ 300 and 60 ≤ y ≤ 300 and 60 ≤ z ≤ 300 } (All inputs are valid)  
I9 = { 70 ≤ x ≤ 300 and 70 ≤ y ≤ 300 and 70 ≤ z ≤ 300 } (All inputs are valid)  
I10 = { 80 ≤ x ≤ 300 and 80 ≤ y ≤ 300 and 80 ≤ z ≤ 300 } (All inputs are valid)  
I11 = { 90 ≤ x ≤ 300 and 90 ≤ y ≤ 300 and 90 ≤ z ≤ 300 } (All inputs are valid)  
I12 = { 100 ≤ x ≤ 300 and 100 ≤ y ≤ 300 and 100 ≤ z ≤ 300 } (All inputs are valid)  
I13 = { 201 ≤ x ≤ 301 and 201 ≤ y ≤ 300 and 201 ≤ z ≤ 300 } (x is invalid, y is valid and z is valid)  
I14 = { 301 ≤ x and 1 ≤ y ≤ 300 and 1 ≤ z ≤ 300 } (x is invalid y is valid and z is valid)  
I15 = { 100 ≤ x ≤ 300 and y < 1 and 100 ≤ z ≤ 300 } (x is valid, y is invalid and z is valid)  
I16 = { 100 ≤ x ≤ 300 and 100 ≤ y ≤ 300 and  z < 1 } (x is valid, y is valid and z is invalid)  
 
**Question 2**
 
**a)**  
 
```

public class FizzBuzz {  
    public static String deterFizzBuzz(int n){
     
     String result;
 
 if (n %3 ==0 && n %5 == 0){
     result = "FizzBuzz";
 }else if (n % 5 ==0 ){
    result = "Buzz!";
 }else if (n % 3 ==0){
    result = "Fizz!";
 }else {
     result = n + "!";
   }
 return result;
}  
}
```
 
**b)**  
Test 2 can be removed while keep a good test suite  
 
**c)**  
Equivalence partitioning  
Test 2 is a repetition of Test 1, Test 1 and Test 2 are testing the same thing.  
It will all return the same value which is FizzBuzz.  
 
**d)**
```
import org.junit.Test;
import org.junit.Assert;

public class FizzBuzzTest {
    FizzBuzz test = new FizzBuzz();

    @Test
    void isFizzBuzz() {
        int n = 15;
        Sring expected = "FizzBuzz"  ;
        String result = test.deterFizzBuzz(n);
        Assert.assertEquals(expected, result);
    }

    @Test
    void isFizz() {
        int n =3;
        String expected ="Fizz!";
        String result = test.deterFizzBuzz(n);
        Assert.assertEquals(expected, result);
    }

    @Test
    void isBuzz() {
        int n =5;
        String expected ="Buzz!";
        String result = test.deterFizzBuzz(n);
        Assert.assertEquals(expected, result);
    }

    @Test
    void is_not_FizzBuzz() {
        int n = 2;
        String expected = "2!";
        String result = test.deterFizzBuzz(n);
        Assert.assertEquals(expected, result);
    }

}
```
**Question3**
 
 **a)**  
 T1=VIII=8  
 T2=LI=51  
 T3=CLVI= 156  
 T4=MDCCCXLII=1842  
 T5=999=CMXCIX
 
 
**b)**
```
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 
@Test
Void one_numberValue(){
    String nums = VIII;
    int expected =8;
    int value = value.convert(nums);
    Assert.assertEqual(expected,value);
}
@Test
void two_NumberValue(){
    String nums = LI ;
    int expected =51;
    int value = value.convert(nums);
    Assert.assertEqual(expected,value);
}
 
@Test
void three_NumberValue(){
    String nums = CLVI ;
    int expected = 156;
    int value = value.convert(nums);
    Assert.assertEqual(expected,value);;
}
 
@Test
void four_NumberValue(){
    String nums = MDCCCXLII ;
    int expected =1842;
    int value = value.convert(nums);
    Assert.assertEqual(expected,value);
}
 
@Test
void the_ZeroValue(){
    String nums = CMXCIX ;
    int expected = 999;
    int value = value.convert(nums);
    Assert.assertEqual(expected,value);
}
```

