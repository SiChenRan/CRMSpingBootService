package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
@TableName("sale_chance")
public class SaleChance implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 销售机会编号
     */
    @TableId(value = "sal_id", type = IdType.AUTO)
    private Integer salId;

    /**
     * 客户名称
     */
    private String cusName;

    /**
     * 机会来源：1.促销、2.广告、3.搜索引擎、4.线上咨询、5.电话查询、6.邮件咨询、7.客户介绍
     */
    private Integer salChanceSource;

    /**
     * 联系人
     */
    private String salContact;

    /**
     * 联系电话
     */
    private String salContactTel;

    /**
     * 成功几率%
     */
    private Integer salSuccessRate;

    /**
     * 概要
     */
    private String salAbs;

    /**
     * 机会描述
     */
    private String salDesc;

    /**
     * 创建人
     */
    private String salCreator;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime salCreatTime;

    /**
     * 指派给
     */
    private String salAssto;

    /**
     * 指派时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime salAssTime;

    /**
     * 状态：1.未分配、2.已分配、3.开发成功、4.开发失败
     */
    private Integer salState;

    public Integer getSalId() {
        return salId;
    }

    public void setSalId(Integer salId) {
        this.salId = salId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Integer getSalChanceSource() {
        return salChanceSource;
    }

    public void setSalChanceSource(Integer salChanceSource) {
        this.salChanceSource = salChanceSource;
    }

    public String getSalContact() {
        return salContact;
    }

    public void setSalContact(String salContact) {
        this.salContact = salContact;
    }

    public String getSalContactTel() {
        return salContactTel;
    }

    public void setSalContactTel(String salContactTel) {
        this.salContactTel = salContactTel;
    }

    public Integer getSalSuccessRate() {
        return salSuccessRate;
    }

    public void setSalSuccessRate(Integer salSuccessRate) {
        this.salSuccessRate = salSuccessRate;
    }

    public String getSalAbs() {
        return salAbs;
    }

    public void setSalAbs(String salAbs) {
        this.salAbs = salAbs;
    }

    public String getSalDesc() {
        return salDesc;
    }

    public void setSalDesc(String salDesc) {
        this.salDesc = salDesc;
    }

    public String getSalCreator() {
        return salCreator;
    }

    public void setSalCreator(String salCreator) {
        this.salCreator = salCreator;
    }

    public LocalDateTime getSalCreatTime() {
        return salCreatTime;
    }

    public void setSalCreatTime(LocalDateTime salCreatTime) {
        this.salCreatTime = salCreatTime;
    }

    public String getSalAssto() {
        return salAssto;
    }

    public void setSalAssto(String salAssto) {
        this.salAssto = salAssto;
    }

    public LocalDateTime getSalAssTime() {
        return salAssTime;
    }

    public void setSalAssTime(LocalDateTime salAssTime) {
        this.salAssTime = salAssTime;
    }

    public Integer getSalState() {
        return salState;
    }

    public void setSalState(Integer salState) {
        this.salState = salState;
    }

    @Override
    public String toString() {
        return "SaleChance{" +
        "salId = " + salId +
        ", cusName = " + cusName +
        ", salChanceSource = " + salChanceSource +
        ", salContact = " + salContact +
        ", salContactTel = " + salContactTel +
        ", salSuccessRate = " + salSuccessRate +
        ", salAbs = " + salAbs +
        ", salDesc = " + salDesc +
        ", salCreator = " + salCreator +
        ", salCreatTime = " + salCreatTime +
        ", salAssto = " + salAssto +
        ", salAssTime = " + salAssTime +
        ", salState = " + salState +
        "}";
    }
}
