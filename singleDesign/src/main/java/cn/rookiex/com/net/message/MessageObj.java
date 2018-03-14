package cn.rookiex.com.net.message;

/**
 * @ Author: xu
 * @ Date: create in 2018/3/14 17:25
 * @ Description:
 **/
public class MessageObj {
    private int msgID;
    private byte[] data;

    public void setMsgID(int msgID) {
        this.msgID = msgID;
    }

    public int getMsgID() {
        return msgID;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }
}
