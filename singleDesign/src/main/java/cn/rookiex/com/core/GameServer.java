package cn.rookiex.com.core;

/**
 * @ Author: xu
 * @ Date: create in 2018/3/14 17:06
 * @ Description:负责游戏的启动,关闭
 **/
public class GameServer {
    public static void main(String[] args) {

    }
    private static void startServer() throws Exception{
        // TODO: 2018/3/14 开启服务器
        //init
        //web.start
        //netty.start
    }

    public static void stopServer() {
        // TODO: 2018/3/14 关闭服务器
        //关闭socket
        //关闭定时调度任务
        //关闭web
        //同步缓存
        //更新数据
    }
}
