package FinalTermWork;

/**
 * @author HuangLongQiang黄龙强
 * @version 1.0
 * @date 2022/12/15 10:03
 */
public class Message2 {
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
                "订单号：'" + orderNumber + '\'' +
                ", 收件人姓名：'" + name + '\'' +
                ", 收件人电话：'" + telephone + '\'' +
                ", 收货地址：'" + address + '\'' +
                ", 备注：'" + remark + '\'' +
                '】';
    }

    public Message2() {
    }

    public Message2(String orderNumber, String name, String telephone, String address, String remark) {
        this.orderNumber = orderNumber;
        this.name = name;
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
