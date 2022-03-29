package wzz.digou.pojo;

public class CustomAddress {
    private String shipping_name;// 物流名称
    private String shipping_code;// 物流单号

    public String getShipping_name() {
        return shipping_name;
    }

    public void setShipping_name(String shipping_name) {
        this.shipping_name = shipping_name;
    }

    public String getShipping_code() {
        return shipping_code;
    }

    public void setShipping_code(String shipping_code) {
        this.shipping_code = shipping_code;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public String getReceiver_state() {
        return receiver_state;
    }

    public void setReceiver_state(String receiver_state) {
        this.receiver_state = receiver_state;
    }

    public String getReceiver_city() {
        return receiver_city;
    }

    public void setReceiver_city(String receiver_city) {
        this.receiver_city = receiver_city;
    }

    public String getReceiver_district() {
        return receiver_district;
    }

    public void setReceiver_district(String receiver_district) {
        this.receiver_district = receiver_district;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public String getReceiver_zip() {
        return receiver_zip;
    }

    public void setReceiver_zip(String receiver_zip) {
        this.receiver_zip = receiver_zip;
    }

    private String receiver_name;// 姓名
    private String receiver_phone;// 手机号
    private String receiver_state;// 省份
    private String receiver_city;// 城市
    private String receiver_district;// 区县
    private String receiver_address;// 地址
    private String receiver_zip;// 邮政编码

    public CustomAddress() {
    }

    public CustomAddress(String receiver_name, String receiver_phone, String receiver_state, String receiver_city, String receiver_district, String receiver_address, String receiver_zip) {
        this.receiver_name = receiver_name;
        this.receiver_phone = receiver_phone;
        this.receiver_state = receiver_state;
        this.receiver_city = receiver_city;
        this.receiver_district = receiver_district;
        this.receiver_address = receiver_address;
        this.receiver_zip = receiver_zip;
    }
}
