package com.gasq.bdp.logn.utils;

public enum SexEnum implements IEnum {


    male(1, "男"), female(2, "女");
 
    private int key;
    private String value;
    private SexEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
 
    public int getKey() {
        return key;
    }
 
    public void setKey(int key) {
        this.key = key;
    }
 
    public String getValue() {
        return value;
    }
 
    public void setValue(String value) {
        this.value = value;
    }

}
