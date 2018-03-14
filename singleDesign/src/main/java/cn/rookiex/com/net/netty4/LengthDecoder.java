package cn.rookiex.com.net.netty4;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class LengthDecoder extends LengthFieldBasedFrameDecoder {

	public LengthDecoder(int maxFrameLength, int lengthFieldOffset,
			int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {

		super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment,
				initialBytesToStrip);
	}
	
	@Override
    protected ByteBuf extractFrame(ChannelHandlerContext ctx, ByteBuf buffer, int index, int length) {
        return buffer.slice(index, length);
    }
	
	@Override
	protected Object decode(ChannelHandlerContext ctx, ByteBuf in)
			throws Exception {

//		if (in == null) return null;
//
//		Object obj = super.decode(ctx, in);
//		if (obj == null) return null;
//
//		ByteBuf buf = (ByteBuf) obj;
//	//	ByteBuf buf = in;
//		int readableLen = buf.readableBytes(); // 可读的数据大小
//
//		if (readableLen > Netty4CodeFactory.MAX_LENGH) { // 数据异常
//			System.out.println("shujuyichang");
//			Attribute<Connection> attr = ctx.attr(Netty4MessageHandler.STATE);
//			if (attr != null) {
//				logError(attr.get());
//			} else {
//				logError(null);
//			}
//			ctx.channel().close();
//			return null;
//		}

		Object result = null;
//		if (readableLen >= 4 && readableLen < Netty4CodeFactory.MAX_LENGH) { // 消息头占4个字节
//			//in.markReaderIndex();
//			byte[] body = new byte[readableLen - 4];  //  我们读到的长度，满足我们的要求了，把传送过来的数据取出来
//			// 消息编号
//			int msgID = buf.readInt();
//			buf.readBytes(body);
//			result = convertToObject(msgID, body);  // 将byte数据转化为我们需要的对象。
//
//		}

		return result;
	}

//	private MessageObj convertToObject(int msgID, byte[] data) {
//
//		MessageObj obj = new MessageObj();
//		obj.setMsgID(msgID);
//		obj.setData(GameSocketService.decryptForDis(data));
//
//		return obj;
//	}

	/**
	 * 记录错误
	 * */
//	private void logError(Connection con) {
//		if (con != null) {
//			LogUtil.error("data tool long Exception! playerID:"+con.getId());
//		} else {
//			LogUtil.error("data tool long Exception!");
//		}
//	}
}
