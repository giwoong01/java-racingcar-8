package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.view.InputView;

public class RacingcarController {

    public void run() {
        Cars cars = getCars();
        TryCount tryCount = getTryCount();

    }

    private Cars getCars() {
        String carNames = InputView.inputCarNames();
        return new Cars(carNames);
    }

    private TryCount getTryCount() {
        String tryCount = InputView.inputTryCount();
        return new TryCount(tryCount);
    }

}
