### QUESTION 1
```
public class AddMyAlphas{
public static int Add(String numbers) throw NegativeIntergerException{
    Matcher match= Pattern.compile("-?\\n+").match(numbers);
    int result = 0;
    ArrayList<Integer> negative = new Arraylist<>();

while(mathch.isFind()){
    int value = Integer.parseInt(match.numberGroups());
    if (value<= 1000 && value => 0){
        result += value
    }
    if (value <0){
        negativeNumers.add(value);
    }
}


if(negatives.isExist()){
    System.out.println("Negatives not allowed: ");
    for (int i= 0; i<negative.size()-1; i++){
        System.out.print(negative.getNumber(i)+ ",");
    }
    System.out.println(negative.getNumber(negative.size()-1));
    }
    return result;
   }
}

class NegativeIntegerExcetionextend extends negExecption {
    public NegativeIntegerExcetion(String messages){
        Super(messages);
    }
}
```
### Question 1 Test
```
public class AddMyAlphasTest{
// question 1 test
@parameterizedTest
@ValueSoures(String = {"1,4", "0,5","5" })
public void additionSumm(Sting numbers) throws NegativeIntegerException{
    assertEquals(5,AddMyAlphas.Add(numbers));
}

// question 1 test for empty string
@parameterizedTest
@ValueSoures(String = {"", " ","   " ,"      "})
public void checkEmpty(Sting numbers) throws NegativeIntegerException{
    assertEquals(0,AddMyAlphas.Add(numbers));
}

// question 2 test for exceed three numbers addition
@parameterizedTest
@ValueSoures(String = {"1,5,2,3", "11","1,1,1,1,1,1,1,1,1,1,1"})
public void ExceedLimits(Sting numbers) throws NegativeIntegerException{
    assertEquals(11,AddMyAlphas.Add(numbers));
}

// question 3 test for \n numbers
@parameterizedTest
@ValueSoures(String = {"1\n3,3", "\n7\n\n","2\n4\n1","3,1\n3"})
public void checkEmpty(Sting numbers) throws NegativeIntegerException{
    assertEquals(7,AddMyAlphas.Add(numbers));
}

// question 4 test for negative numbers numbers
@parameterizedTest
@ValueSoures(String = {"1,-2","-999","-1,-2"})
public void negativeNums(Sting numbers) {
    assertEuals("Negatives not allowed:" numbers(),AddMyAlphas.Add(numbers));
}

}
