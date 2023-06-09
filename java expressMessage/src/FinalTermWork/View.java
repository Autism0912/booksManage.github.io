package FinalTermWork;

/**
 * @author HuangLongQiang黄龙强
 * @version 1.0
 * @date 2022/11/30 16:50
 */
public class View {
    protected void login(){
        System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+"+"\n"+
                "欢迎来到四川航天职业技术学院快递系统管理界面"+"\n"+"当前为登录界面~!~!~"+"\n"+
                "普通用户请按：1"+"\n"+"快递管理员请按：2"+"\n"+
                "+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
    }

    protected  void manager(){
        System.out.println("当前是管理员后台页面");
        System.out.println("增加快递信息请按：1");
        System.out.println("删除快递信息请按：2");
        System.out.println("查询快递信息请按：3");
        System.out.println("更改快递信息请按：4");
        System.out.println("退出管理页面请按：5");
        System.out.println("强制停用程序请按：6");
        System.out.println("请操作！！！");
    }
    protected void commonUser(){
        System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+"+"\n"+
                "登录成功~~当前为普通用户"+
                "\n"+"取出快递请按：1"+"\n"+"查看快递请按：2"+"\n"+"退出普通用户界面界面请按：3"+"\n"
                +"+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
    }

}
