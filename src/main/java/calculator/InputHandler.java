package calculator;

import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;

// 프로그램의 입력을 담당
// 한줄을 읽고 String 형태로 반환

public class InputHandler {
    public static String input(){
        String inputs;
        try {
            inputs = Console.readLine();
        }
        catch (Exception e){
            inputs = "";
        }

        return inputs;

    }
}
