package jude.kakao.com.elevator;

public class Elevator {
    final int MAX_FLOOR, CAPACITY;
    int curFloor = 1;
    Direction curDirection = Direction.STOP;
    State state = State.STOP;

    Elevator (int MaxFloor, int capacity) {
        this.MAX_FLOOR = MaxFloor;
        this.CAPACITY = capacity;
    }

    public enum State { STOP, MOVE, OPEN, CLOSE}

}
