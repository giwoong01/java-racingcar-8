package racingcar.domain.power;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomPowerGenerator implements PowerGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
