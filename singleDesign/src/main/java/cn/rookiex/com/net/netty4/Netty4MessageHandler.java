package cn.rookiex.com.net.netty4;


import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import org.apache.log4j.Logger;

public class Netty4MessageHandler extends SimpleChannelInboundHandler<Object> {

    //private GameDataHandlerService dataHandlerService = new GameDataHandlerService();
    private Logger logger = Logger.getLogger(WebSocketNetty4Server.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

            ctx.channel().close();


             super.channelInactive(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg)
            throws Exception {

        // TODO: 2018/3/14  执行消息的处理



    }

    public void operationComplete(ChannelFuture f){
        if(!f.isSuccess()){
            f.cause().printStackTrace();
        }
    }

//    private void dealExit(Connection connection) {
//        GameContext.getInstance().getActionCollection().getCommonAction().exitGame(connection, 3);
//    }


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }

}
