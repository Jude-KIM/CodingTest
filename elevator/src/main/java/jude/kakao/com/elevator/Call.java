package jude.kakao.com.elevator;

public class Call {
    private int callTime, orig, dest, userId, enterTime, exitTime;

    //    public Request(int ts, int userId, int orig, int dest) {
    public Call(int ts, int orig, int dest, int userId) {
        this.callTime = ts;
        this.orig = orig;
        this.dest = dest;
        this.userId = userId;
    }

    public int getTime() {
        return callTime;
    }

    public int getOrig() {
        return orig;
    }

    public int getDest() {
        return dest;
    }

    public int getID() {
        return userId;
    }

    public Direction getDirection() {
        if(orig > dest)
            return Direction.DOWN;
        return Direction.UP;
    }

    public void setEnterTime(int value) {
        this.enterTime = value;
    }

    public void setExitTime(int value) {
        this.exitTime = value;
    }

    public int getEnterTIme() {
        return enterTime;
    }

    public int getExitTIme() {
        return exitTime;
    }

    public int getWaitingTime() {
        return enterTime - callTime;
    }

    public int getTravelTime() {
        return exitTime - enterTime;
    }
}
