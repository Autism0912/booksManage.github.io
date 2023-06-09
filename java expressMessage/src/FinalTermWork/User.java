package FinalTermWork;

import java.io.OutputStream;
import java.net.Socket;
import java.sql.*;
import java.util.Scanner;

/**
 * @author HuangLongQiang黄龙强
 * @version 1.0
 * @date 2022/12/7 14:06
 */
public class User {
    //创建VIEW视图类这个对象
    View view = new View();
    //创建数据库这个对象
    Databases databases = new Databases();
    //创建线程的这个对象 用来获取当前是时间
    Thread_loginTime time = new Thread_loginTime();
    //管理员类
    //定义三个变量用来储存数据库地址，账户名称，数据库的密码
    private static final String URL = "JDBC:mysql://localhost:3306/express";
    private static final String USER = "root";
    private static final String PASSWD = "20020912";
    private String sql = "select *  from user where name =?";
    Scanner sc = new Scanner(System.in);
    public  void picCheck(String name, String passwd) throws Exception{
        String name1 = name;
        String passwd1 = passwd;
        try (Connection conn = DriverManager.getConnection(URL,USER,PASSWD)){
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,name1);
            ResultSet rs = pre.executeQuery();
            while (true){
                if (rs.next()){
                    String account = rs.getString(2);
                    String pic = rs.getString(3);
                    Socket client = new Socket("127.0.0.1",9095);
                    System.out.println("连接服务器成功");
                    OutputStream out = client.getOutputStream();
                    String message = "普通用户："+name1+"~登录成功";
                    out.write(message.getBytes());
                    if (pic.equals(passwd1)){

                        time.run();
                        while (true) {

                            view.commonUser();
                            int num = sc.nextInt();
                            switch (num) {
                                case 1:
                                    System.out.println("请输入您要取出快件的取件码");
                                    String picCode = sc.next();
                                    int c =4;
                                    databases.delete(picCode,c);
                                    break;
                                case 2:
                                    databases.orderNumber();
                                    break;
                                case 3:
                                    String a = "已经退出";
                                    return;
                                default:
                                    System.out.println("序号有误！！，请您重新操作");
                                    break;
                            }
                        }

                    }else {
                        System.out.println("密码错误");
                        break;
                    }

                }else {
                    System.out.println("登录失败");
                    System.out.println("无此用户信息，请您核对后重新登录！！！");
                    break;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
