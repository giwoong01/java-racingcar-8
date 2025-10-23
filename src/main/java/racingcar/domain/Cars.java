package racingcar.domain;

import java.util.Arrays;
import java.util.IllformedLocaleException;
import java.util.List;
import java.util.Set;

public class Cars {

    private static final String DELIMITER = ",";
    private static final String ERROR_MESSAGE_DUPLICATE_NAME = "자동차의 이름은 중복될 수 없습니다.";

    private final List<Car> cars;

    public Cars(String carNames) {
        List<Name> names = parseCarNames(carNames);
        validateDuplicateNames(names);

        this.cars = names.stream()
                .map(Car::from)
                .toList();
    }

    private List<Name> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(String::trim)
                .map(Name::new)
                .toList();
    }

    private void validateDuplicateNames(List<Name> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllformedLocaleException(ERROR_MESSAGE_DUPLICATE_NAME);
        }
    }

}
