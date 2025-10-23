package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @DisplayName("시도 횟수가 정상적으로 생성됩니다.")
    @Test
    void 시도_횟수_정상_생성() {
        // given
        String inputTryCount = "3";

        // when
        TryCount tryCount = new TryCount(inputTryCount);

        // then
        assertThat(tryCount.getCount()).isEqualTo(3);
    }

    @DisplayName("시도 횟수가 0 또는 음의 정수인 경우 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-2"})
    void 시도_횟수_0_음의_정수_예외(String value) {
        // given
        String inputTryCount = value;

        // when & when
        assertThatThrownBy(() -> new TryCount(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 문자로 입력되는 경우 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    void 시도_횟수_문자_예외(String value) {
        // given
        String inputTryCount = value;

        // when & when
        assertThatThrownBy(() -> new TryCount(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}