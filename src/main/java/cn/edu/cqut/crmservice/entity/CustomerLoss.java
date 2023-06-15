package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Haibara
 * @since 2023-06-15
 */
@TableName("customer_loss")
public class CustomerLoss implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 流失预警ID，主键，自动递增
     */
    @TableId(value = "cl_id", type = IdType.AUTO)
    private Integer clId;

    /**
     * 客户ID
     */
    private Integer cusId;

    /**
     * 客户经理ID
     */
    private Integer suId;

    /**
     * 上次下单时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date clOrderTime;

    /**
     * 暂缓流失措施
     */
    private String clPause;

    /**
     * 确认流失原因
     */
    private String clLossReason;

    /**
     * 确认流失时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date clLossTime;

    /**
     * 状态。1-预警、2-暂缓、3-流失、4-挽回
     */
    private Integer clStatus;

    @TableField(exist = false)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getClId() {
        return clId;
    }

    public void setClId(Integer clId) {
        this.clId = clId;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusSalesman() {
        return customer.getCusSalesman();
    }

    public Date getClOrderTime() {
        return clOrderTime;
    }

    public void setClOrderTime(Date clOrderTime) {
        this.clOrderTime = clOrderTime;
    }

    public String getClPause() {
        return clPause;
    }

    public void setClPause(String clPause) {
        this.clPause = clPause;
    }

    public String getClLossReason() {
        return clLossReason;
    }

    public void setClLossReason(String clLossReason) {
        this.clLossReason = clLossReason;
    }

    public Date getClLossTime() {
        return clLossTime;
    }

    public void setClLossTime(Date clLossTime) {
        this.clLossTime = clLossTime;
    }

    public Integer getClStatus() {
        return clStatus;
    }

    public void setClStatus(Integer clStatus) {
        this.clStatus = clStatus;
    }

    public Integer getSuId() {
        return suId;
    }

    public void setSuId(Integer suId) {
        this.suId = suId;
    }

    public CustomerLoss(Integer clId, Integer cusId, Integer suId, Date clOrderTime, String clPause, String clLossReason, Date clLossTime, Integer clStatus, Customer customer) {
        this.clId = clId;
        this.cusId = cusId;
        this.suId = suId;
        this.clOrderTime = clOrderTime;
        this.clPause = clPause;
        this.clLossReason = clLossReason;
        this.clLossTime = clLossTime;
        this.clStatus = clStatus;
        this.customer = customer;
    }

    public CustomerLoss() {
    }

    @Override
    public String toString() {
        return "CustomerLoss{" +
                "clId=" + clId +
                ", cusId=" + cusId +
                ", suId=" + suId +
                ", clOrderTime=" + clOrderTime +
                ", clPause='" + clPause + '\'' +
                ", clLossReason='" + clLossReason + '\'' +
                ", clLossTime=" + clLossTime +
                ", clStatus=" + clStatus +
                ", customer=" + customer +
                '}';
    }
}
