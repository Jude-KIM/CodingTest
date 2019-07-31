package jude.kakao.com.codingtest.model;

public class Request {

    private int time, orig, dest, userId;

    public Request(int ts, int userId, int orig, int dest) {
        this.time = ts;
        this.orig = orig;
        this.dest = dest;
        this.userId = userId;
    }

    public int getTime() {
        return time;
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
}
