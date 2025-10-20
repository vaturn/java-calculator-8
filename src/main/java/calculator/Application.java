package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            // 입력
            String inputs = InputHandler.input();

            // 파싱
            List<Integer> numList = Parser.parse(inputs);

            // 계산
            int results = Calculator.calculate(numList);

            // 출력
            OutputHandler.output(results);
        } catch (IllegalArgumentException e) {
            OutputHandler.errput(e.getMessage());
            OutputHandler.errput("Invalid Token is " + e.getWrongPosition());
            throw e;
        } catch (Exception e) {
            OutputHandler.errput(e.getMessage());
            throw e;
        }
    }
}
