package FinalTermWork;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author HuangLongQiang黄龙强
 * @version 1.0
 * @date 2022/11/30 17:30
 */
public class SystemDesign {
    //1.创建视图对象
    View system = new View();
    //2.创建键盘录入技术的这个对象
    Scanner scanner = new Scanner(System.in);
    //创建普通用户的这个对象 CommonUser
    Manger commonUser = new Manger();
    //创建普通用户这个对象
    User user = new User();


    public void system() throws Exception {
        while (true) {
            system.login();
            int num = scanner.nextInt();
            try {
                System.out.println("请耐心等待，系统正在为您跳转！！");
                Thread.sleep(3000);
                System.out.println("跳转成功！！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (num) {
                case 1:
                    //当前普通用户视图模块
                    System.out.println("请输入您的账号");
                    String UserNum = scanner.next();
                    System.out.println("请输入您的密码");
                    String ps = scanner.next();
                    try {
                        System.out.println("请耐心等待，正在为您登录");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.picCheck(UserNum,ps);
                    break;
                case 2:
                    //当前为管理员用户的取件模块
                    System.out.println("请你输入您的账号");
                    String account = scanner.next();
                    System.out.println("请输入您的密码");
                    String passwd = scanner.next();
                    try {
                        System.out.println("请耐心等待，正在为您登录");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    commonUser.picCheck(account,passwd);
                    break;
                default:
                    System.out.println("您输入的序号有误，请您重新输入");
                    break;
            }
        }
    }
}