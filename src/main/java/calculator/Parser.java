package calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parser {
    public static List<Integer> parse(String inputs){

        int index = -1;
        if(inputs.length() > 4 && inputs.charAt(0) == '/' && inputs.charAt(1) == '/'){
            // 문자열에 \n 이 없으면 -1 반환
            index = inputs.indexOf("\\n");
        }

        Set<Character> delimiters = new HashSet<>();
        delimiters.add(':');
        delimiters.add(',');

        if(index != -1)
            delimiters.addAll(getDelimiter(inputs.substring(2, index)));

        return parseByToken(inputs.substring(index + 1), delimiters);
    }

    // 선택 구분자를 파싱하는 함수
    private static Set<Character> getDelimiter(String inputs){
        Set<Character> customDelimiters = new HashSet<>();

        for(char ch: inputs.toCharArray()){
            customDelimiters.add(ch);
        }

        return customDelimiters;
    }

    // 구분자를 매개변수로 넘겨줌
    private static List<Integer> parseByToken(String inputs, Set<Character> delimiters){

        int curNumber = 0;
        List<Integer> results = new ArrayList<>();

        for(char ch : inputs.toCharArray()){
            if(delimiters.contains(ch)){
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
