package calculator;

import java.util.Arrays;

public class IllegalArgumentException extends RuntimeException{
    private final char wrongToken;
    public IllegalArgumentException(char wrongToken){
        super("Invalid string input");
        this.wrongToken = wrongToken;
    }

    // 오류가 발생한 토큰 반환
    public char getWrongPosition() {
        return wrongToken;
    }
}
