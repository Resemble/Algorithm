package com.cn.vo;
public class PublisherVo {
    private String name;//出版社名称
    private String address;
    private String ppcode;
    private String netAddress;//出版社地址

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPpcode() {
        return ppcode;
    }

    public void setPpcode(String ppcode) {
        this.ppcode = ppcode;
    }

    public String getNetAddress() {
        return netAddress;
    }

    public void setNetAddress(String netAddress) {
        this.netAddress = netAddress;
    }
}
