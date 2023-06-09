package FinalTermWork;

/**
 * @author HuangLongQiang黄龙强
 * @version 1.0
 * @date 2022/12/7 14:36
 */
public class Message {
    private int id;
    private String orderNumber;
    private String name;
    private String picupcode;
    private String telephone;
    private String address;
    private String remark;

    @Override
    public String toString() {
        return "快递信息：【" +
                "序号：" + id +
                ", 订单号：'" + orderNumber + '\'' +
                ", 收件人姓名：'" + name + '\'' +
                ", 取件码：'" + picupcode + '\'' +
                ", 电话号码：'" + telephone + '\'' +
                ", 收件人地址：'" + address + '\'' +
                ", 备注：'" + remark + '\'' +
                '】';
    }

    public Message(int id, String orderNumber, String name, String picupcode, String telephone, String address, String remark) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.name = name;
        this.picupcode = picupcode;
        this.telephone = telephone;
        this.address = address;
        this.remark = remark;
    }

    public Message(String orderNumber, String picupcode, String telephone, String address, String remark) {
        this.orderNumber = orderNumber;
        this.picupcode = picupcode;
        this.telephone = telephone;
        this.address = address;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicupcode() {
        return picupcode;
    }

    public void setPicupcode(String picupcode) {
        this.picupcode = picupcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
