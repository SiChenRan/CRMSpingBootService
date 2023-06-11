package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT
 * @since 2023-06-11
 */
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号，主键，自动递增
     */
    @TableId(value = "su_id", type = IdType.AUTO)
    private Integer suId;

    /**
     * 用户名
     */
    private String suName;

    /**
     * 用户密码
     */
    private String suPwd;

    /**
     * 用户角色
     */
    private String suRole;

    public Integer getSuId() {
        return suId;
    }

    public void setSuId(Integer suId) {
        this.suId = suId;
    }

    public String getSuName() {
        return suName;
    }

    public void setSuName(String suName) {
        this.suName = suName;
    }

    public String getSuPwd() {
        return suPwd;
    }

    public void setSuPwd(String suPwd) {
        this.suPwd = suPwd;
    }

    public String getSuRole() {
        return suRole;
    }

    public void setSuRole(String suRole) {
        this.suRole = suRole;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        "suId = " + suId +
        ", suName = " + suName +
        ", suPwd = " + suPwd +
        ", suRole = " + suRole +
        "}";
    }
}
