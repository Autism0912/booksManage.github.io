package FinalTermWork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author HuangLongQiang黄龙强
 * @version 1.0
 * @date 2022/12/7 13:58
 */
public class Databases {
    //定义一个数据类，用来实现对数据库的增删查改

    //定义三个变量用来储存数据库地址，账户名称，数据库的密码
    private static final String URL = "JDBC:mysql://localhost:3306/express";
    private static final String USER = "root";
    private static final String PASSWD = "20020912";
    //改
    static String ChDate1 = "update expressmess set name= ? where OrderNumber=? ";
    static String ChDate2 = "update expressmess set telephone=? where OrderNumber=? ";
    static String ChDate3 = "update expressmess set address=? where OrderNumber=? ";
    static String ChDate4 = "update expressmess set remark=? where OrderNumber=? ";
    static String select = "select * from expressmess where OrderNumber=?";

    //增
    void insert() {
        Random r = new Random();
        String insert = "insert into expressmess(OrderNumber,name,picupcode,telephone,address,remark) values(?,?,?,?,?,?)";
        //5.调用一个
        String code1 = r.OderNumberCode(15);//订单号
        String code2 = r.creteVerifyCode(5);//取件码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的姓名");
        String name = sc.next();
        System.out.println("请输入您的电话号码");
        String tel = sc.next();
        if (tel.length() == 11) {
            String telNum = tel;
            System.out.println("请输入您的收货地址");
            String address = sc.next();
            System.out.println("如有备注请输入");
            String remark = sc.next();
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWD)) {
                try (PreparedStatement sta = conn.prepareStatement(insert)) {
                    sta.setString(1, code1);
                    sta.setString(2, name);
                    sta.setString(3, code2);
                    sta.setString(4, telNum);
                    sta.setString(5, address);
                    sta.setString(6, remark);
                    sta.executeUpdate();
                } finally {


                    System.out.println("+----------------------------------------------------+" + "\n\r" + "您的快递添加成功！！" + "\n\r" + "您的取件码是：" + code2 + "\n\r" + "您的订单号是：" + code1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("您输入的电话号码位数有误请您核对后再输入");
        }

    }

    //删
    void delete(String pic,int a) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWD)) {
            String sql = "delete from expressmess where picupcode=?";
            try (PreparedStatement sta = connection.prepareStatement(sql)) {
                sta.setString(1, pic);
                sta.executeUpdate();

                if (a==3){
                    System.out.println("删除快件成功");
                }else if(a==4){
                    System.out.println("取件成功");
                }
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    //改
    void change() {
        Scanner sc = new Scanner(System.in);
        System.out.println("+----------------------------------------------------+");
        System.out.println("~~~~~~~~~~~~~~~~~~~欢迎来到修改快递信息界面~~~~~~~~~~~~~~~~~");
        System.out.println("+------------------------------------------------------");
        System.out.println("!!修改姓名请按1\n!!修改电话号号码请按2\n!!修改快递收货地址请按3\n!!修改备注信息请按4");
        int ChangeNum = sc.nextInt();
        switch (ChangeNum) {
            case 1:
                System.out.println("请输入您的快递单号");
                String orderNumber = sc.next();
                System.out.println("请输入新的名字");
                String chName = sc.next();
                try (Connection conn = DriverManager.getConnection(URL, USER, PASSWD)) {
                    try (PreparedStatement sta = conn.prepareStatement(ChDate1)) {
                        sta.setString(1, chName);
                        sta.setString(2, orderNumber);
                        sta.executeUpdate();
                    }
                } catch (SQLException e) {
                    System.out.println("您输入的数据有误");
                }
                break;
            case 2:
                System.out.println("请输入您的订单号");
                String OrderNumber2 = sc.next();
                System.out.println("请输入您新的电话号码");
                String telNumber = sc.next();
                try (Connection conn = DriverManager.getConnection(URL, USER, PASSWD)) {
                    try (PreparedStatement sta = conn.prepareStatement(ChDate2)) {
                        sta.setString(1, telNumber);
                        sta.setString(2, OrderNumber2);
                        sta.executeUpdate();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.println("请输入您的订单号");
                String OrderNumber3 = sc.next();
                System.out.println("请输入您新的收货地址");
                String Address = sc.next();
                try (Connection coon = DriverManager.getConnection(URL, USER, PASSWD)) {
                    try (PreparedStatement sta = coon.prepareStatement(ChDate3)) {
                        sta.setString(1, Address);
                        sta.setString(2, OrderNumber3);
                        sta.executeUpdate();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                System.out.println("请输入您的订单号");
                String OrderNumber4 = sc.next();
                System.out.println("请输入您新的备注信息");
                String Remark = sc.next();
                try (Connection conn = DriverManager.getConnection(URL, USER, PASSWD)) {
                    try (PreparedStatement sta = conn.prepareStatement(ChDate4)) {
                        sta.setString(1, Remark);
                        sta.setString(2, OrderNumber4);
                        sta.executeUpdate();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            default:
                System.out.println("您输入的序号有误，请您重新输入");

        }

    }

    void select() {

        List<Message> expressmess = new ArrayList<>();
        List<com.mysql.cj.protocol.Message> expressmess2 = new ArrayList<>();
        try (Connection coon = DriverManager.getConnection(URL, USER, PASSWD)) {
            String select2 = "select * from expressmess";
            try (PreparedStatement sta = coon.prepareStatement(select2)) {
//                sta.setString(1, OrderNum1);
                try (ResultSet rs = sta.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String orderNum2 = rs.getNString(2);
                        String name1 = rs.getNString(3);
                        String pic = rs.getString(4);
                        String telNumber = rs.getNString(5);
                        String addressMess = rs.getNString(6);
                        String remarkMess = rs.getNString(7);
                        expressmess.add(new Message(id, orderNum2, name1, pic, telNumber, addressMess, remarkMess));
                    }
                }
                for (Message c : expressmess) {
                    System.out.println(c);

                }
            }

        } catch (SQLException e) {
//                            e.printStackTrace();
            System.out.println("操作异常");

        }

    }

    List<Message2> expressmess = new ArrayList<>();

    public void orderNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("+----------------------------------------------------+");
        System.out.println("~~~~~~~~~~~~~~~~~~~欢迎来到查询快递信息界面~~~~~~~~~~~~~~~~~");
        System.out.println("请输入您的订单号");
        String OrderNum1 = sc.next();
        try (Connection coon = DriverManager.getConnection(URL, USER, PASSWD)) {
            try (PreparedStatement sta = coon.prepareStatement(select)) {
                sta.setString(1, OrderNum1);
                try (ResultSet rs = sta.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String orderNum2 = rs.getNString(2);
                        String name1 = rs.getNString(3);
                        String telNumber = rs.getNString(5);
                        String addressMess = rs.getNString(6);
                        String remarkMess = rs.getNString(7);
                        expressmess.add(new Message2(orderNum2, name1, telNumber, addressMess, remarkMess));
                    }
                    for (Message2 c : expressmess) {
                        System.out.println(c);
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class Random {
        //声明一个工具类，随机生成订单号,取件码
        //随机数生成订单号
        public String OderNumberCode(int a) {
            String OrderCode = "";
            String data = "123456789";
            java.util.Random r = new java.util.Random();
            for (int i = 0; i < a; i++) {
                int index = r.nextInt(data.length());
                data.charAt(index);
                OrderCode += data.charAt(index);
            }
            return OrderCode;
        }

        //随机数生成取件码
        public String creteVerifyCode(int a) {
            String OrderCode = "";
            String data = "abcdefghijkmlnopqwstuvwxyzABCDEFGHIJKMLNOPQRSTUVWXYZ123456789";
            java.util.Random r = new java.util.Random();
            for (int i = 0; i < a; i++) {
                int index = r.nextInt(data.length());
                data.charAt(index);
                OrderCode += data.charAt(index);
            }
            return OrderCode;
        }
    }
}