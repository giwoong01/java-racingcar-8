package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @DisplayName("이름이 정상적으로 생성됩니다.")
    @Test
    void 이름_정상_생성() {
        // given
        String inputName = "woong";

        // when
        Name name = new Name(inputName);

        // then
        assertThat(name.name()).isEqualTo("woong");
    }

    @DisplayName("이름이 비어있거나 공백인 경우 예외가 발생합니다.")
    @ParameterizedTest
    @NullAndEmptySource
    void 이름_EMPTY_공백_예외(String value) {
        // given
        String name = value;

        // when & then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 5자를 초과하는 경우 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "bbbbbb", "cccccccc"})
    void 이름_5자_초과_예외(String value) {
        // given
        String name = value;

        // when & then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}