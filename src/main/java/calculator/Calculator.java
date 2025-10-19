package calculator;

import java.util.List;

public class Calculator {
    public static int calculate(List<Integer> arryNums){

        int sum = 0;

        for(int num: arryNums)
            sum += num;
        return sum;
    }
}
