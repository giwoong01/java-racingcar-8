package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("위치가 정상적으로 0으로 초기화 되어 생성됩니다.")
    @Test
    void 위치_정상_생성() {
        // given
        Position position = new Position();

        // when
        int value = position.getValue();

        // then
        assertThat(value).isEqualTo(0);
    }

    @DisplayName("addPosition 메소드 호출시 1 증가합니다.")
    @Test
    void 위치_addPosition_호출_1_증가() {
        // given
        Position position = new Position();
        position.addPosition();

        // when

        // then
        assertThat(position.isSameAs(1)).isTrue();
    }

    @DisplayName("주어진 정수와 현재 위치 값이 같으면 true를 반환합니다.")
    @Test
    void 주어진_정수_현재_위치_같음_TRUE() {
        // given
        Position position = new Position();

        // when

        // then
        assertThat(position.isSameAs(0)).isTrue();
    }

    @DisplayName("주어진 정수와 현재 위치 값이 다르면 false를 반환합니다.")
    @Test
    void 주어진_정수_현재_위치_다름_FALSE() {
        // given
        Position position = new Position();

        // when

        // then
        assertThat(position.isSameAs(1)).isFalse();
    }

    @DisplayName("현재 위치만큼 주어진 마크를 반복하여 문자열로 반환합니다.")
    @Test
    void 현재_위치_마크_반복_문자열_반환() {
        // given
        Position position = new Position();
        position.addPosition();
        position.addPosition();

        // when
        String result = position.toMarkString("-");

        // then
        assertThat(result).isEqualTo("--");
    }

}