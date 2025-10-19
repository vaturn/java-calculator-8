package calculator;

public class OutputHandler {
    public static int output(Object data){
        if(data == null){
            // null 값이라 출력 못함
            return -1;
        }

        System.out.println(data);
        return 1;
    }
}
