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
        int value = position.getValue();

        // then
        assertThat(value).isEqualTo(1);
    }

}