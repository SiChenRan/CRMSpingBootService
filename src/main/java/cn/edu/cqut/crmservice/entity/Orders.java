package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Haibara
 * @since 2023-06-14
 */
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号，主键，自动递增
     */
    @TableId(value = "odr_id", type = IdType.AUTO)
    private Integer odrId;

    /**
     * 订单日期
     */
    private Date odrTime;

    /**
     * 订单金额
     */
    private BigDecimal odrAmount;

    /**
     * 送货地址
     */
    private String odrShipto;

    /**
     * 订单状态。1-未付款、2-已付款、3-已发货、4-已收货、5-已退货
     */
    private Integer odrStatus;

    /**
     * 客户编号
     */
    private Integer cusId;

    public Integer getOdrId() {
        return odrId;
    }

    public void setOdrId(Integer odrId) {
        this.odrId = odrId;
    }

    public Date getOdrTime() {
        return odrTime;
    }

    public void setOdrTime(Date odrTime) {
        this.odrTime = odrTime;
    }

    public BigDecimal getOdrAmount() {
        return odrAmount;
    }

    public void setOdrAmount(BigDecimal odrAmount) {
        this.odrAmount = odrAmount;
    }

    public String getOdrShipto() {
        return odrShipto;
    }

    public void setOdrShipto(String odrShipto) {
        this.odrShipto = odrShipto;
    }

    public Integer getOdrStatus() {
        return odrStatus;
    }

    public void setOdrStatus(Integer odrStatus) {
        this.odrStatus = odrStatus;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "odrId=" + odrId +
                ", odrTime=" + odrTime +
                ", odrAmount=" + odrAmount +
                ", odrShipto='" + odrShipto + '\'' +
                ", odrStatus=" + odrStatus +
                ", cusId=" + cusId +
                '}';
    }
}
