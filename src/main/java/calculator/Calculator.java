package calculator;

import java.util.List;

public class Calculator {
    public static int calculate(List<Integer> arrayNums){

        int sum = 0;

        for(int num: arrayNums)
            sum += num;
        return sum;
    }
}
