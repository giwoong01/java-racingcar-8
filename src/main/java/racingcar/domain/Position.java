package racingcar.domain;

public class Position {

    private int value;

    public Position() {
        value = 0;
    }

    public void addPosition() {
        this.value++;
    }

    public int getValue() {
        return value;
    }
}
