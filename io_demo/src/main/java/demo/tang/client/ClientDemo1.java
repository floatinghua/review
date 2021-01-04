package demo.tang.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author ：tangfan
 * @date ：Created in 2021/1/4 10:42
 * @description：
 * @modified By：
 */
public class ClientDemo1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 8080));
        OutputStream os = socket.getOutputStream();
        String str = "测试1";
        os.write(str.getBytes());
        os.close();
        socket.close();
    }
}
