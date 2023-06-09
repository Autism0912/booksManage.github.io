package FinalTermWork;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author HuangLongQiang黄龙强
 * @version 1.0
 * @date 2022/12/15 15:15
 */
public class Thread_loginTime extends Thread {
    public Thread_loginTime() {
    }

    public Thread_loginTime(String name) {
        super(name);
    }

    @Override
    public void run() {
        SimpleDateFormat a1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        {
            System.out.println("当前时间是："+a1.format(date));
        }
    }
}
