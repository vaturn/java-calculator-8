package calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parser {
    public static List<Integer> parse(String inputs){
        return parseBasicToken(inputs);
    }

    public static List<Integer> parseBasicToken(String inputs){
        Set<Character> delimiter = new HashSet<>();

        // 기본 구분자
        delimiter.add(',');
        delimiter.add(':');

        int curNumber = 0;
        List<Integer> results = new ArrayList<>();

        for(char ch : inputs.toCharArray()){
            if(delimiter.contains(ch)){
                results.add(curNumber);
                curNumber = 0;
            }
            else if(Character.isDigit(ch)) {
                curNumber = curNumber * 10 + Character.getNumericValue(ch);
            }
        }
        results.add(curNumber);
        return results;
    }
}
