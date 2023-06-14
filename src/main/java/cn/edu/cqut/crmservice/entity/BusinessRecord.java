package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 *
 * </p>
 *
 * @author CQUT
 * @since 2023-06-09
 */
@TableName("business_record")
public class BusinessRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户交往记录编号
     */
    @TableId(value = "rec_id", type = IdType.AUTO)
    private Integer recId;

    /**
     * 客户交往日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDate recDate;

    /**
     * 客户交往地点
     */
    private String recLoc;

    /**
     * 客户交往概要
     */
    private String recSummary;

    /**
     * 客户交往详细信息
     */
    private String recDetail;

    /**
     * 客户编号
     */
    private Integer cusId;

    /**
     * 销售员
     */
    private String salesmanName;

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public LocalDate getRecDate() {
        return recDate;
    }

    public void setRecDate(LocalDate recDate) {
        this.recDate = recDate;
    }

    public String getRecLoc() {
        return recLoc;
    }

    public void setRecLoc(String recLoc) {
        this.recLoc = recLoc;
    }

    public String getRecSummary() {
        return recSummary;
    }

    public void setRecSummary(String recSummary) {
        this.recSummary = recSummary;
    }

    public String getRecDetail() {
        return recDetail;
    }

    public void setRecDetail(String recDetail) {
        this.recDetail = recDetail;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    @Override
    public String toString() {
        return "BusinessRecord{" +
                "recId = " + recId +
                ", recDate = " + recDate +
                ", recLoc = " + recLoc +
                ", recSummary = " + recSummary +
                ", recDetail = " + recDetail +
                ", cusId = " + cusId +
                ", salesmanName = " + salesmanName +
                "}";
    }
}
