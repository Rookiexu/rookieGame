package cn.rookiex.com.net.netty4;

import cn.rookiex.com.beans.ConfigBean;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;

/**
 * @ Author: xu
 * @ Date: create in 2018/3/14 17:24
 * @ Description:
 **/
public class WebSocketNetty4Server {

    private static final EventLoopGroup bossGroup = new NioEventLoopGroup();
    private static final EventLoopGroup workerGroup = new NioEventLoopGroup();

    private Logger logger = Logger.getLogger(WebSocketNetty4Server.class);

    private WebSocketNetty4Server() {
    }

    public static WebSocketNetty4Server getInstance() {
        return SingletonHolder.instance;
    }

    public void start(ConfigBean configBean) throws Exception {

        try {
            logger.info("WebSocketNetty4Server  ----> start ");

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<Channel>() {

                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new Netty4CodeFactory());
                        }

                    })
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .option(ChannelOption.SO_RCVBUF, 32 * 1024)
                    .option(ChannelOption.SO_SNDBUF, 32 * 1034)
                    .option(ChannelOption.SO_KEEPALIVE, true);


            ChannelFuture cf = bootstrap.bind(configBean.getIp(), configBean.getPort()).sync();

            logger.info("WebSocketNetty4Server start complete -----> complete");

            cf.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

    private static final class SingletonHolder {
        private static final WebSocketNetty4Server instance = new WebSocketNetty4Server();
    }
}
