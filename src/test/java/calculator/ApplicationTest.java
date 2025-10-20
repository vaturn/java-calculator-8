package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 특이_케이스() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // 이 부분은 요구사항에 따라 결과가 달라질 수 있음
    @Test
    void 특이_케이스2() {
        assertSimpleTest(() -> {
            run(":");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // 이 부분은 요구사항에 따라 결과가 달라질 수 있음
    @Test
    void 특이_케이스3() {
        assertSimpleTest(() -> {
            run("::,:,");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // 이 부분은 요구사항에 따라 결과가 달라질 수 있음
    @Test
    void 특이_케이스4() {
        assertSimpleTest(() -> {
            run("//;,\\n,,:;;");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // 이 부분은 요구사항에 따라 결과가 달라질 수 있음
    // 숫자가 구분자인 경우
    @Test
    void 특이_케이스5() {
        assertSimpleTest(() -> {
            run("//0\\n120302405");
            assertThat(output()).contains("결과 : 44");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_사용2() {
        assertSimpleTest(() -> {
            run("123,2495:3342,32432,2323:3431");
            assertThat(output()).contains("결과 : 44146");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용1() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // 커스텀 구분자 사용
    @Test
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_사용3() {
        assertSimpleTest(() -> {
            run("//,\\n1,2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_사용4() {
        assertSimpleTest(() -> {
            run("//-\\n1-2-3-4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    // 여기서부터 적용되는 커스텀 구분자는 요구사항에 따라 변경될 수 있음
    @Test
    void 커스텀_구분자_사용5() {
        assertSimpleTest(() -> {
            run("//-.,\\n1-2.3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2:3,."))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2:3,."))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
