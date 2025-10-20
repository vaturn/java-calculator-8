package calculator;

public class IllegalArgumentException extends RuntimeException{
    public IllegalArgumentException(int index){
        super("잘못된 문자열 입력");
    }
}
