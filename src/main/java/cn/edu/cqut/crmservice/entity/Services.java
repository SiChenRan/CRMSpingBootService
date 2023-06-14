package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author CQUT
 * @since 2023-06-09
 */
public class Services implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 服务编号
     */
    @TableId(value = "ser_id", type = IdType.AUTO)
    private Integer serId;

    /**
     * 服务类型：咨询、投诉、建议
     */
    private String serType;

    /**
     * 服务概要
     */
    private String serSummary;

    /**
     * 服务详细要求
     */
    private String serDetail;

    /**
     * 客户编号
     */
    private Integer cusId;

    /**
     * 服务创建人：当前登录用户
     */
    private String serCreator;

    /**
     * 服务创建时间：当前系统时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime serCreateTime;

    /**
     * 服务状态：新创建、已分配、已处理、已归档
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String serState;

    /**
     * 服务分配时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime serAllocTime;

    /**
     * 处理人
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String serHandler;

    /**
     * 服务处理方法
     */
    private String serProcessMethod;

    /**
     * 服务处理时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(updateStrategy = FieldStrategy.IGNORED)//解决MyBatisPlus不能传递null的localDateTIme
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime serProcessTime;

    /**
     * 客户反馈
     */
    private String serCusFeedback;

    /**
     * 客户满意度:1,2,3,4,5
     */
    private Integer serCusRate;

    /**
     * 客户反馈时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime serFeedbackTime;

    public Integer getSerId() {
        return serId;
    }

    public void setSerId(Integer serId) {
        this.serId = serId;
    }

    public String getSerType() {
        return serType;
    }

    public void setSerType(String serType) {
        this.serType = serType;
    }

    public String getSerSummary() {
        return serSummary;
    }

    public void setSerSummary(String serSummary) {
        this.serSummary = serSummary;
    }

    public String getSerDetail() {
        return serDetail;
    }

    public void setSerDetail(String serDetail) {
        this.serDetail = serDetail;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getSerCreator() {
        return serCreator;
    }

    public void setSerCreator(String serCreator) {
        this.serCreator = serCreator;
    }

    public LocalDateTime getSerCreateTime() {
        return serCreateTime;
    }

    public void setSerCreateTime(LocalDateTime serCreateTime) {
        this.serCreateTime = serCreateTime;
    }

    public String getSerState() {
        return serState;
    }

    public void setSerState(String serState) {
        this.serState = serState;
    }

    public LocalDateTime getSerAllocTime() {
        return serAllocTime;
    }

    public void setSerAllocTime(LocalDateTime serAllocTime) {
        this.serAllocTime = serAllocTime;
    }

    public String getSerHandler() {
        return serHandler;
    }

    public void setSerHandler(String serHandler) {
        this.serHandler = serHandler;
    }

    public String getSerProcessMethod() {
        return serProcessMethod;
    }

    public void setSerProcessMethod(String serProcessMethod) {
        this.serProcessMethod = serProcessMethod;
    }

    public LocalDateTime getSerProcessTime() {
        return serProcessTime;
    }

    public void setSerProcessTime(LocalDateTime serProcessTime) {
        this.serProcessTime = serProcessTime;
    }

    public String getSerCusFeedback() {
        return serCusFeedback;
    }

    public void setSerCusFeedback(String serCusFeedback) {
        this.serCusFeedback = serCusFeedback;
    }

    public Integer getSerCusRate() {
        return serCusRate;
    }

    public void setSerCusRate(Integer serCusRate) {
        this.serCusRate = serCusRate;
    }

    public LocalDateTime getSerFeedbackTime() {
        return serFeedbackTime;
    }

    public void setSerFeedbackTime(LocalDateTime serFeedbackTime) {
        this.serFeedbackTime = serFeedbackTime;
    }

    @Override
    public String toString() {
        return "Services{"
                + "serId = "
                + serId
                + ", serType = "
                + serType
                + ", serSummary = "
                + serSummary
                + ", serDetail = "
                + serDetail
                + ", cusId = "
                + cusId
                + ", serCreator = "
                + serCreator
                + ", serCreateTime = "
                + serCreateTime
                + ", serState = "
                + serState
                + ", serAllocTime = "
                + serAllocTime
                + ", serHandler = "
                + serHandler
                + ", serProcessMethod = "
                + serProcessMethod
                + ", serProcessTime = "
                + serProcessTime
                + ", serCusFeedback = "
                + serCusFeedback
                + ", serCusRate = "
                + serCusRate
                + ", serFeedbackTime = "
                + serFeedbackTime
                + "}";
    }
}
