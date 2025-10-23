package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.power.FixedPowerGenerator;
import racingcar.domain.power.PowerGenerator;

class CarTest {

    @DisplayName("자동차 생성 시 초기 위치는 0 입니다.")
    @Test
    void 자동차_생성_초기_위치_0() {
        // given
        Car car = new Car(new Name("woong"));

        // when
        Position position = car.getPosition();

        // then
        assertThat(position.getValue()).isZero();
    }

    @DisplayName("전진 조건(4 이상)을 만족하면 위치가 1 증가합니다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_4_이상_전진(int value) {
        // given
        Car car = new Car(new Name("woong"));
        PowerGenerator powerGenerator = new FixedPowerGenerator(value);

        // when
        car.move(powerGenerator.generate());

        // then
        assertThat(car.getPosition().getValue()).isEqualTo(1);
    }

    @DisplayName("전진 조건(4 미만)을 만족하지 못하면 위치는 변하지 않습니다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 자동차_4_미만_전진_X(int value) {
        // given
        Car car = new Car(new Name("woong"));
        PowerGenerator powerGenerator = new FixedPowerGenerator(value);

        // when
        car.move(powerGenerator.generate());

        // then
        assertThat(car.getPosition().getValue()).isEqualTo(0);
    }

    @DisplayName("자동차의 위치가 초기 상태일 때 이름만 출력합니다.")
    @Test
    void 자동차_위치_초기_이름_출력() {
        // given
        Car car = new Car(new Name("woong"));

        // when & then
        assertThat(car.toString()).isEqualTo("woong : ");
    }

    @DisplayName("자동차가 전진하면 하이픈을 출력합니다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 자동차_전진_하이픈_출력(int value) {
        // given
        Car car = new Car(new Name("woong"));
        PowerGenerator powerGenerator = new FixedPowerGenerator(value);

        // when
        car.move(powerGenerator.generate());

        // then
        assertThat(car.toString()).isEqualTo("woong : -");
    }

}