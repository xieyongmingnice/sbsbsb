
package com.commons.core.message;

/**
 * TODO
 */
public abstract class Message {

    protected int flag;

    public static int SUCCESS = 1;

    public static int FAILURE = -1;

    public Message(int code) {
        this.setFlag(code);
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

}
