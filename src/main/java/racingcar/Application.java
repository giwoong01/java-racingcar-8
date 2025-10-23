package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.domain.power.RandomPowerGenerator;

public class Application {

    public static void main(String[] args) {
        RacingcarController racingcarController = new RacingcarController(
                new RandomPowerGenerator()
        );
        racingcarController.run();
    }

}
