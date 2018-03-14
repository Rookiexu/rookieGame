package cn.rookiex.com.net;

/**
 * @ Author: xu
 * @ Date: create in 2018/3/14 20:28
 * @ Description:
 **/
public class Codec {
    public static byte[] decryptForDis (byte[] bytes){
        byte buff;
        for(int i=0; i<bytes.length; i+=5) {
            if (i + 3 > bytes.length - 1) break;
            buff = bytes[i + 2];
            bytes[i + 2] = (byte) ~bytes[i + 3];
            bytes[i + 3] = buff;
        }

        return bytes;
    }
}
