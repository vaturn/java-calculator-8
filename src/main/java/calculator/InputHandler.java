package calculator;

import java.util.Scanner;

// 프로그램의 입력을 담당
// 한줄을 읽고 String 형태로 반환

public class InputHandler {
    public static String input(){
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
