package racingcar.domain;

public class Car {

    private static final int ZERO = 0;
    private static final int MOVE_THRESHOLD = 4;

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

    @Override
    public String toString() {
        return name.name() + " : " + "-".repeat(Math.max(ZERO, position.getPosition()));
    }

}
