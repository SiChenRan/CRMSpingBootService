package cn.edu.cqut.crmservice.util;

import java.util.List;

public class TableResult<T> {
    //后台返回的状态码，0表示执行成功，其他值不成功
    private int code;
    //后台返回的提示信息，若请求失败，数据表格会把提示信息显示出来
    private String msg;
    //表里的总记录数，用于计算分页
    private long count;
    //当前页面要显示的数据
    private List<T> data;

    public TableResult(int code, String msg, long count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public static <T> TableResult<T> ok(String msg, long count, List<T> data) {//静态方法在static后重新声明泛型<T>
        return new TableResult<T>(0, msg, count, data);
    }

    public static <T> TableResult<T> ok(String msg) {//静态方法在static后重新声明泛型<T>
        return new TableResult<T>(0, msg, 0, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
