package racingcar.domain;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_THRESHOLD = 4;
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String POSITION_MARK = "-";

    private final Name name;
    private final Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
    }

    public static Car from(Name name) {
        return new Car(name);
    }

    public void move(int power) {
        if (isMove(power)) {
            position.addPosition();
        }
    }

    private boolean isMove(int power) {
        return power >= MOVE_THRESHOLD;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name.name() + NAME_POSITION_SEPARATOR + POSITION_MARK.repeat(Math.max(INITIAL_POSITION, position.getValue()));
    }

}
