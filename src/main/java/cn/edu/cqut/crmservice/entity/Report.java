package cn.edu.cqut.crmservice.entity;

import java.io.Serializable;

public class Report implements Serializable {
    private String item;
    private long value;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Report{" +
                "item='" + item +
                ", value=" + value +
                '}';
    }
}
