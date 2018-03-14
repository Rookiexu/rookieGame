package cn.rookiex.com.net.netty4;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;

/**
 * @ Author: xu
 * @ Date: create in 2018/3/14 20:13
 * @ Description:
 **/
public class WebSocketMessageToByte extends MessageToByteEncoder{
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        if (msg instanceof BinaryWebSocketFrame) {
            out.writeBytes(((BinaryWebSocketFrame)msg).content());
        }
    }
}
