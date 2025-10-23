package racingcar.domain;

public class Position {

    private int position;

    public Position() {
        position = 0;
    }

    public void addPosition() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
    
}
