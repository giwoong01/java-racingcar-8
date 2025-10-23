package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RacingcarController {

    public void run() {
        String carNames = InputView.inputCarNames();
        Cars cars = new Cars(carNames);


    }

}
