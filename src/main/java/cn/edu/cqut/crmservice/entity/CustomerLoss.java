package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Haibara
 * @since 2023-06-14
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
    private String cusSalesman;

    /**
     * 上次下单时间
     */
    private LocalDateTime clOrderTime;

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
    private LocalDateTime clLossTime;

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
        return cusSalesman;
    }

    public void setCusSalesman(String cusSalesman) {
        this.cusSalesman = cusSalesman;
    }

    public LocalDateTime getClOrderTime() {
        return clOrderTime;
    }

    public void setClOrderTime(LocalDateTime clOrderTime) {
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

    public LocalDateTime getClLossTime() {
        return clLossTime;
    }

    public void setClLossTime(LocalDateTime clLossTime) {
        this.clLossTime = clLossTime;
    }

    public Integer getClStatus() {
        return clStatus;
    }

    public void setClStatus(Integer clStatus) {
        this.clStatus = clStatus;
    }

    public String getCusName() {
        return customer.getCusName();
    }

    @Override
    public String toString() {
        return "CustomerLoss{" +
                "clId=" + clId +
                ", cusId=" + cusId +
                ", cusSalesman='" + cusSalesman + '\'' +
                ", clOrderTime=" + clOrderTime +
                ", clPause='" + clPause + '\'' +
                ", clLossReason='" + clLossReason + '\'' +
                ", clLossTime=" + clLossTime +
                ", clStatus=" + clStatus +
                ", customer=" + customer +
                '}';
    }
}
