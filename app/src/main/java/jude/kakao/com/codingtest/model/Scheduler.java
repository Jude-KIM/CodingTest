package jude.kakao.com.codingtest.model;

import java.util.LinkedList;
import java.util.Queue;

import jude.kakao.com.codingtest.elevator.Elevator;

//현재는 FIFO
public class Scheduler {

    private Queue<Request> queue;
    private Elevator elevator;

    public Scheduler(Elevator elevator) {
        this.queue = new LinkedList<>();
        this.elevator = elevator;
    }

    public void submit(Request request) {
        queue.add(request);
    }

    private void schedule() {
        while(!queue.isEmpty()) {
            Request req = queue.poll();
            elevator.addRequest(req);
        }
    }

    private boolean hasRequest() {
        return !queue.isEmpty();
    }

    public void start() {
        while(hasRequest() || elevator.hasRequest()) {
            schedule();
            elevator.move();
        }
    }

    public String getResult() {
        return elevator.result.toString();
    }
}
