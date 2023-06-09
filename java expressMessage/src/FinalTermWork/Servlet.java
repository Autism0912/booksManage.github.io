package FinalTermWork;
import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * @author HuangLongQiang黄龙强
 * @version 1.0
 * @date 2022/12/15 11:47
 */
public class Servlet {
    //tcp多线程
    public static void main(String[] args) throws IOException {
        System.out.println("服务器已经开启了，等待用户接入...");
        while (true){
        ServerSocket server = new ServerSocket(9095);
        Socket client =server.accept();//这里才代表已经启动成功了
        System.out.println("有客户端接入，客户端ip是"+client);
        InputStream in = client.getInputStream();
        byte[] data = new byte[1024];
        int len = in.read(data);
        String message = new String(data,0,len);
        System.out.println(message);
        server.close();
        client.close();
    }
}
}