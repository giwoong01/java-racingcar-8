package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.power.FixedPowerGenerator;
import racingcar.domain.power.PowerGenerator;

class CarsTest {

    @DisplayName("유효한 이름들로 자동차 목록을 생성합니다.")
    @Test
    void 자동차_목록_생성() {
        // given
        String carNames = "woong,gi";

        // when
        Cars cars = new Cars(carNames);

        // then
        assertThat(cars.toString()).isEqualTo("woong : \ngi : ");
    }

    @DisplayName("중복된 이름이 존재하면 예외가 발생합니다.")
    @Test
    void 자동차_목록_이름_중복_예외() {
        // given
        String carNames = "woong,gi,woong";

        // when & then
        assertThatThrownBy(() -> new Cars(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("각 자동차들이 성공적으로 이동합니다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void 자동차_목록_이동_성공(int value) {
        // given
        Cars cars = new Cars("woong,gi,choi");
        PowerGenerator powerGenerator = new FixedPowerGenerator(value);

        // when
        cars.moveAll(powerGenerator);

        // then
        assertThat(cars.toString()).isEqualTo("woong : -\ngi : -\nchoi : -");
    }

    @DisplayName("각 자동차들이 이동하지 않습니다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 자동차_목록_이동_X(int value) {
        // given
        Cars cars = new Cars("woong,gi,choi");
        PowerGenerator powerGenerator = new FixedPowerGenerator(value);

        // when
        cars.moveAll(powerGenerator);

        // then
        assertThat(cars.toString()).isEqualTo("woong : \ngi : \nchoi : ");
    }

    @DisplayName("우승자가 한 명일 경우, 해당 우승자 이름을 출력합니다.")
    @Test
    void 우승자_한명_출력() {
        // given
        Cars cars = new Cars("woong,gi");
        PowerGenerator powerGenerator = new PowerGenerator() {
            private final List<Integer> powers = List.of(3, 4);
            private int index = 0;

            @Override
            public int generate() {
                return powers.get(index++);
            }
        };
        cars.moveAll(powerGenerator);

        // when
        String winners = cars.winnerNames();

        // then
        assertThat(winners).isEqualTo("gi");
    }

    @DisplayName("우승자가 여러 명일 경우, 우승자 이름을 쉼표(,)로 구분하여 출력합니다.")
    @Test
    void 우승자_여러명_출력() {
        // given
        Cars cars = new Cars("woong,gi,choi");
        PowerGenerator powerGenerator = new PowerGenerator() {
            private final List<Integer> powers = List.of(3, 4, 5);
            private int index = 0;

            @Override
            public int generate() {
                return powers.get(index++);
            }
        };
        cars.moveAll(powerGenerator);

        // when
        String winners = cars.winnerNames();

        // then
        assertThat(winners).isEqualTo("gi, choi");
    }

    @DisplayName("모든 자동차가 움직이지 않은 경우, 모든 자동차를 우승자로 출력합니다.")
    @Test
    void 우승자_모두_출력() {
        // given
        Cars cars = new Cars("woong,gi,choi");
        PowerGenerator powerGenerator = new PowerGenerator() {
            private final List<Integer> powers = List.of(3, 2, 1);
            private int index = 0;

            @Override
            public int generate() {
                return powers.get(index++);
            }
        };
        cars.moveAll(powerGenerator);

        // when
        String winners = cars.winnerNames();

        // then
        assertThat(winners).isEqualTo("woong, gi, choi");
    }

}