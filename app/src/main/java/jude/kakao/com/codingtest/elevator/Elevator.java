package jude.kakao.com.codingtest.elevator;

import java.util.LinkedList;
import java.util.Queue;

import jude.kakao.com.codingtest.elevator.ElevatorActivity;
import jude.kakao.com.codingtest.model.Request;

public class Elevator {

    private int current_level;//현재 층
    public enum Status {IDLE, OCCUPIED, PICKUP}
    public enum Direction { UP, DOWN, STOP}

    public Queue<Request> queue;
    public Request currentRequest;
    private Status status;
    private Direction direction;
    public StringBuilder result = new StringBuilder();
    private int numberOfPassengers;
    public int target_level;

    public Elevator(int level, int capacity, int elapse) {
        numberOfPassengers = 0;
        direction = Direction.STOP;
        current_level = 1;
        queue = new LinkedList<>();
    }

    public void move() {
        if(currentRequest == null && queue.isEmpty()) {
            stop();
            return;
        }

        if(currentRequest == null) {
            currentRequest = queue.poll();
            if(currentRequest.getTime() > ElevatorActivity.TIME)
                ElevatorActivity.TIME = currentRequest.getTime();
            if(current_level != currentRequest.getOrig()) {
                status = Status.PICKUP;
                target_level = currentRequest.getOrig();
            } else {
                status = Status.OCCUPIED;
                target_level = currentRequest.getDest();
            }
        }

        if(currentRequest.getTime() > ElevatorActivity.TIME) {
            ElevatorActivity.TIME = currentRequest.getTime();
        }

        if(current_level == target_level) {
            if(status == Status.OCCUPIED) {
                addLog(currentRequest.getDest(), "exit", currentRequest.getID());
                currentRequest = null;
            } else {
                addLog(currentRequest.getOrig(), "enter", currentRequest.getID());
                target_level = currentRequest.getDest();
                status = Status.OCCUPIED;
            }
        } else if(current_level < target_level) {
            up();
        } else if(current_level > target_level) {
            down();
        }
    }

    private void addLog(int floor, String action, int ID) {
        result.append(ElevatorActivity.TIME).append(",")
                .append(floor).append(",")
                .append(action).append(",")
                .append(ID).append("\n");
    }

    private void up() {
        ElevatorActivity.TIME++;
        current_level++;
        this.direction = Direction.UP;
    }

    private void down() {
        ElevatorActivity.TIME++;
        current_level--;
        this.direction = Direction.DOWN;
    }

    private void stop() {
        direction = Direction.STOP;
        status = Status.IDLE;
    }

    public void addRequest(Request request) {
        queue.add(request);
    }

    public Direction getDirection() {
        return this.direction;
    }

    public boolean hasRequest() {
        return  this.queue.size() > 0 || this.currentRequest != null;
    }
}
