package calculator;

public class OutputHandler {
    public static void output(Object data){
        if(data == null){
            // null 값이라 출력 못함
            return;
        }

        System.out.println(data);
    }
}
