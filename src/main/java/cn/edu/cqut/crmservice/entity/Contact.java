package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT
 * @since 2023-06-08
 */
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户联系人的唯一标识
     */
    @TableId(value = "con_id", type = IdType.AUTO)
    private Integer conId;

    /**
     * 用户联系人姓名
     */
    private String conName;

    /**
     * 联系人性别:男，女
     */
    private String conGender;

    /**
     * 联系人的职位
     */
    private String conJob;

    /**
     * 联系人的办公电话
     */
    private String conTel;

    /**
     * 联系人的手机
     */
    private String conPhone;

    /**
     * 联系人的备注
     */
    private String conDesc;

    /**
     * 客户编号
     */
    private Integer cusId;

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public String getConGender() {
        return conGender;
    }

    public void setConGender(String conGender) {
        this.conGender = conGender;
    }

    public String getConJob() {
        return conJob;
    }

    public void setConJob(String conJob) {
        this.conJob = conJob;
    }

    public String getConTel() {
        return conTel;
    }

    public void setConTel(String conTel) {
        this.conTel = conTel;
    }

    public String getConPhone() {
        return conPhone;
    }

    public void setConPhone(String conPhone) {
        this.conPhone = conPhone;
    }

    public String getConDesc() {
        return conDesc;
    }

    public void setConDesc(String conDesc) {
        this.conDesc = conDesc;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "Contact{" +
        "conId = " + conId +
        ", conName = " + conName +
        ", conGender = " + conGender +
        ", conJob = " + conJob +
        ", conTel = " + conTel +
        ", conPhone = " + conPhone +
        ", conDesc = " + conDesc +
        ", cusId = " + cusId +
        "}";
    }
}
