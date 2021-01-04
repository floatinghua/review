package demo.tang.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：tangfan
 * @date ：Created in 2021/1/4 10:42
 * @description：
 * @modified By：
 */
public class ServerDemo1 {
    public static void main(String[] args) throws IOException {
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue workQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 20, 5, unit, workQueue);
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket accept = serverSocket.accept();
            System.out.println("阻塞中");
            poolExecutor.execute(new MyThread(accept));
            System.out.println("完成一个");
        }
    }
}
