package racingcar.domain;

public class Car {

    private Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = 0;
    }

    public static Car from(Name name) {
        return new Car(name);
    }

}
