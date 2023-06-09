package FinalTermWork;

import java.io.OutputStream;
import java.net.Socket;
import java.sql.*;
import java.util.Scanner;

/**
 * @author HuangLongQiang黄龙强
 * @version 1.0
 * @date 2022/11/30 17:26
 */
public class Manger {
    //创建VIEW视图类这个对象
    View view = new View();
    //创建数据库这个对象
    Databases databases = new Databases();
    //创建线程对象，用于对获取当前时间
    Thread_loginTime time = new Thread_loginTime();
    //管理员类
    //定义三个变量用来储存数据库地址，账户名称，数据库的密码
    private static final String URL = "JDBC:mysql://localhost:3306/express";
    private static final String USER = "root";
    private static final String PASSWD = "20020912";
    private String sql = "select *  from user where name =?";
    Scanner sc = new Scanner(System.in);
   public  String picCheck(String name, String passwd) throws Exception {
       String name1 = name;
       String passwd1 = passwd;
        try (Connection conn = DriverManager.getConnection(URL,USER,PASSWD)){
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,name1);
            ResultSet rs = pre.executeQuery();
            while (true){
                if (rs.next()){
                    Socket client = new Socket("127.0.0.1",9095);
                    System.out.println("连接服务器成功");
                    OutputStream out = client.getOutputStream();
                    String message = "管理员用户："+name1+"~登录成功";
                    out.write(message.getBytes());
                    String account = rs.getString(2);
                    String pic = rs.getString(3);
                    if (pic.equals(passwd1)){
                        System.out.println("登录成功");
                        time.run();
                        while (true) {
                            view.manager();
                            int num = sc.nextInt();
                            switch (num) {
                                case 1:
                                    databases.insert();
                                    break;
                                case 2:
                                    System.out.println("请输入您要删除快件的取件码");
                                    String picCode = sc.next();
                                    int b =3;
                                    databases.delete(picCode,b);
                                    break;
                                case 3:
                                    databases.select();
                                    break;
                                case 4:
                                    databases.change();
                                    break;
                                case 5:
                                    String a = "已经退出";
                                    return a;
                                case 6:
                                    System.out.println("您确定强制停止程序了吗？"+"\n"+"确定请按：1"+"\n"+"不确定请按：2");
                                    String numStop = sc.next();
                                    String numStop1 ="1";
                                    String numStop2 ="2";
                                     if (numStop1.equals(numStop)){
                                         System.exit(0);
                                     }else if(numStop2.equals(numStop)){
                                         System.out.println("已成功取消操作");
                                }else {
                                         System.out.println("操作有误！！");
                                     }
                                    break;
                                default:
                                    System.out.println("序号有误！！，请您重新操作");
                                    break;
                            }

                        }

                    }else {
                        System.out.println("密码错误");
                    }
                    break;
                }else {
                    System.out.println("登录失败");
                    System.out.println("无此账户信息，请您核对后重新登录！！！");
                    break;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return name;
    }
}