package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author CQUT
 * @since 2023-06-13
 */
@TableName("dev_plan")
public class DevPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 开发计划编号
     */
    @TableId(value = "dev_id", type = IdType.AUTO)
    private Integer devId;

    /**
     * 销售机会编号
     */
    private Integer salId;

    /**
     * 计划日期
     */
    private LocalDate devDate;

    /**
     * 计划内容
     */
    private String devDesc;

    /**
     * 执行日期
     */
    private LocalDate devDateexec;

    /**
     * 执行结果
     */
    private String devResult;

    private String devExecutor;

    public String getDevExecutor() {
        return devExecutor;
    }

    public void setDevExecutor(String devExecutor) {
        this.devExecutor = devExecutor;
    }

    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

    public Integer getSalId() {
        return salId;
    }

    public void setSalId(Integer salId) {
        this.salId = salId;
    }

    public LocalDate getDevDate() {
        return devDate;
    }

//    public void setDevDate(LocalDate devDate) {
//        this.devDate = devDate;
//    }

    public void setDevDate(String devDate) {
        this.devDate = LocalDate.parse(devDate);
    }

    public String getDevDesc() {
        return devDesc;
    }

    public void setDevDesc(String devDesc) {
        this.devDesc = devDesc;
    }

    public LocalDate getDevDateexec() {
        return devDateexec;
    }

    public void setDevDateexec(LocalDate devDateexec) {
        this.devDateexec = devDateexec;
    }

    public String getDevResult() {
        return devResult;
    }

    public void setDevResult(String devResult) {
        this.devResult = devResult;
    }

    @Override
    public String toString() {
        return "DevPlan{" +
                "devId = " + devId +
                ", salId = " + salId +
                ", devDate = " + devDate +
                ", devDesc = " + devDesc +
                ", devDateexec = " + devDateexec +
                ", devResult = " + devResult +
                "}";
    }
}
