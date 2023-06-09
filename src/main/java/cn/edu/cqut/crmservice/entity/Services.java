package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2023-06-08
 */
public class Services implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识服务唯一id
     */
    @TableId(value = "ser_id", type = IdType.AUTO)
    private Integer serId;

    /**
     * 服务概要
     */
    private String serAbs;

    /**
     * 包括：咨询、投诉、创建
     */
    private String serType;

    /**
     * 服务的详细要求
     */
    private String serDetReq;

    /**
     * customer表中的用户编号
     */
    private Integer serCusId;

    /**
     * 服务创建者
     */
    private String serCreator;

    /**
     * 服务创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime serCreTime;

    /**
     * 新创建、已分配、已处理、已归档
     */
    private String serState;

    /**
     * 分配时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime serAlloTime;

    /**
     * 处理人
     */
    private String serHandler;

    /**
     * 处理方法
     */
    private String serSolution;

    /**
     * 处理时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime serHandTime;

    /**
     * 客户反馈
     */
    private String serFeed;

    /**
     * 1,2,3,4,5
     */
    private Integer serCusRate;

    /**
     * 反馈时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime serFeedTime;

    public Integer getSerId() {
        return serId;
    }

    public void setSerId(Integer serId) {
        this.serId = serId;
    }

    public String getSerAbs() {
        return serAbs;
    }

    public void setSerAbs(String serAbs) {
        this.serAbs = serAbs;
    }

    public String getSerType() {
        return serType;
    }

    public void setSerType(String serType) {
        this.serType = serType;
    }

    public String getSerDetReq() {
        return serDetReq;
    }

    public void setSerDetReq(String serDetReq) {
        this.serDetReq = serDetReq;
    }

    public Integer getSerCusId() {
        return serCusId;
    }

    public void setSerCusId(Integer serCusId) {
        this.serCusId = serCusId;
    }

    public String getSerCreator() {
        return serCreator;
    }

    public void setSerCreator(String serCreator) {
        this.serCreator = serCreator;
    }

    public LocalDateTime getSerCreTime() {
        return serCreTime;
    }

    public void setSerCreTime(LocalDateTime serCreTime) {
        this.serCreTime = serCreTime;
    }

    public String getSerState() {
        return serState;
    }

    public void setSerState(String serState) {
        this.serState = serState;
    }

    public LocalDateTime getSerAlloTime() {
        return serAlloTime;
    }

    public void setSerAlloTime(LocalDateTime serAlloTime) {
        this.serAlloTime = serAlloTime;
    }

    public String getSerHandler() {
        return serHandler;
    }

    public void setSerHandler(String serHandler) {
        this.serHandler = serHandler;
    }

    public String getSerSolution() {
        return serSolution;
    }

    public void setSerSolution(String serSolution) {
        this.serSolution = serSolution;
    }

    public LocalDateTime getSerHandTime() {
        return serHandTime;
    }

    public void setSerHandTime(LocalDateTime serHandTime) {
        this.serHandTime = serHandTime;
    }

    public String getSerFeed() {
        return serFeed;
    }

    public void setSerFeed(String serFeed) {
        this.serFeed = serFeed;
    }

    public Integer getSerCusRate() {
        return serCusRate;
    }

    public void setSerCusRate(Integer serCusRate) {
        this.serCusRate = serCusRate;
    }

    public LocalDateTime getSerFeedTime() {
        return serFeedTime;
    }

    public void setSerFeedTime(LocalDateTime serFeedTime) {
        this.serFeedTime = serFeedTime;
    }

    @Override
    public String toString() {
        return "Services{" +
                "serId = " + serId +
                ", serAbs = " + serAbs +
                ", serType = " + serType +
                ", serDetReq = " + serDetReq +
                ", serCusId = " + serCusId +
                ", serCreator = " + serCreator +
                ", serCreTime = " + serCreTime +
                ", serState = " + serState +
                ", serAlloTime = " + serAlloTime +
                ", serHandler = " + serHandler +
                ", serSolution = " + serSolution +
                ", serHandTime = " + serHandTime +
                ", serFeed = " + serFeed +
                ", serCusRate = " + serCusRate +
                ", serFeedTime = " + serFeedTime +
                "}";
    }
}
