package cn.rookiex.com.net.netty4;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;


public class Netty4CodeFactory extends ChannelInitializer<SocketChannel> {

	/** 数据包最大长度 */
	public static final int MAX_LENGH = 8192;
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();

		//解码

		   pipeline.addLast("http-codec",new HttpServerCodec());
           pipeline.addLast("aggregator",new HttpObjectAggregator(65536));
           pipeline.addLast("http-chunked",new ChunkedWriteHandler());
          pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
		//编码
		//pipeline.addLast(new Netty4DataEncode());
		//数据处理
		pipeline.addLast("lengthDecode", new LengthDecoder(MAX_LENGH,0,4,0,4));
		pipeline.addLast(new Netty4MessageHandler());
	}

}
