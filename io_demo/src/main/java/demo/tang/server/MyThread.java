package demo.tang.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：tangfan
 * @date ：Created in 2021/1/4 10:58
 * @description：
 * @modified By：
 */
public class MyThread extends Thread {
    private Socket accept;

    public MyThread(Socket serverSocket) {
        this.accept = serverSocket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = accept.getInputStream();
            byte[] bytes = new byte[2048];
            int len = 0;
            while ((len = inputStream.read(bytes)) != -1) {
                inputStream.read(bytes, 0, len);
                System.out.println(new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
