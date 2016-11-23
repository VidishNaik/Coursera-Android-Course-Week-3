package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final int IN = 1;
    public static final int OUT = -1;
    public static final int CLOSED = 0;
    private int mSwing;

    public Gate() {
        mSwing = CLOSED;
    }

    public boolean setSwing(int direction) {
        if (direction != mSwing && direction >= -1 && direction <= 1) {
            mSwing = direction;
            return true;
        }
        return false;
    }

    public boolean open(int direction) {
        return setSwing(direction);
    }

    public void close() {
    }

    public int getSwingDirection() {
        return mSwing;
    }

    public int thru(int count) {
        return getSwingDirection() * count;
    }

    @Override
    public String toString() {
        return "This gate is closed";
    }
}
