package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author baomidou
 * @since 2023-06-06
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户编号
     */
    @TableId(value = "cus_id", type = IdType.AUTO)
    private Integer cusId;

    /**
     * 客户名称
     */
    private String cusName;

    /**
     * 客户地区:东北，西北，华北，华中，华南，西南，华东
     */
    private String cusRegion;

    /**
     * 客户行业：教育，医疗，金融，制造，服务
     */
    private String cusIndustry;

    /**
     * 客户等级：大客户，普通客户，VIP客户
     */
    private String cusLevel;

    /**
     * 客户评分：1，2，3，4，5
     */
    private Integer cusRate;

    /**
     * 信用等级：1，2，3，4，5
     */
    private Integer cusCredit;

    @TableField(exist = false)//属性在数据库里没有对应的字段，将数据库中存储的状态码映射为想要显示的文字
    private String creCreditDesc;

    /**
     * 客户地址
     */
    private String cusAddr;

    /**
     * 客户邮编
     */
    private String cusPostcode;

    /**
     * 客户电话
     */
    private String cusPhone;

    /**
     * 客户网址
     */
    private String cusUrl;

    /**
     * 客户传真
     */
    private String cusFax;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusRegion() {
        return cusRegion;
    }

    public void setCusRegion(String cusRegion) {
        this.cusRegion = cusRegion;
    }

    public String getCusIndustry() {
        return cusIndustry;
    }

    public void setCusIndustry(String cusIndustry) {
        this.cusIndustry = cusIndustry;
    }

    public String getCusLevel() {
        return cusLevel;
    }

    public void setCusLevel(String cusLevel) {
        this.cusLevel = cusLevel;
    }

    public Integer getCusRate() {
        return cusRate;
    }

    public void setCusRate(Integer cusRate) {
        this.cusRate = cusRate;
    }

    public Integer getCusCredit() {
        return cusCredit;
    }

    public void setCusCredit(Integer cusCredit) {
        this.cusCredit = cusCredit;
    }

    public String getCusAddr() {
        return cusAddr;
    }

    public void setCusAddr(String cusAddr) {
        this.cusAddr = cusAddr;
    }

    public String getCusPostcode() {
        return cusPostcode;
    }

    public void setCusPostcode(String cusPostcode) {
        this.cusPostcode = cusPostcode;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusUrl() {
        return cusUrl;
    }

    public void setCusUrl(String cusUrl) {
        this.cusUrl = cusUrl;
    }

    public String getCusFax() {
        return cusFax;
    }

    public void setCusFax(String cusFax) {
        this.cusFax = cusFax;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId = " + cusId +
                ", cusName = " + cusName +
                ", cusRegion = " + cusRegion +
                ", cusIndustry = " + cusIndustry +
                ", cusLevel = " + cusLevel +
                ", cusRate = " + cusRate +
                ", cusCredit = " + cusCredit +
                ", cusAddr = " + cusAddr +
                ", cusPostcode = " + cusPostcode +
                ", cusPhone = " + cusPhone +
                ", cusUrl = " + cusUrl +
                ", cusFax = " + cusFax +
                "}";
    }
}
